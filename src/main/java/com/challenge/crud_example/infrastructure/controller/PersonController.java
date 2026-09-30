package com.challenge.crud_example.infrastructure.controller;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.usecase.*;
import com.challenge.crud_example.infrastructure.controller.request.PersonRequest;
import com.challenge.crud_example.infrastructure.controller.response.PersonResponse;
import com.challenge.crud_example.infrastructure.mapper.PersonMapper;
import com.challenge.crud_example.infrastructure.validator.IdempotencyValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/persons/v1/persons")
@RequiredArgsConstructor
@Slf4j
public class PersonController {
    private final PersonMapper personMapper;
    private final ListPersonUseCase listPersonUseCase;
    private final FindPersonByIdUseCase findPersonByIdUseCase;
    private final CreatePersonUseCase createPersonUseCase;
    private final UpdatePersonUseCase updatePersonUseCase;
    private final DeletePersonUseCase deletePersonUseCase;
    private final IdempotencyValidator idempotencyValidator;
    private final SaveIdempotencyKeyUseCase idempotencyKeyUseCase;

    @GetMapping
    public CollectionModel<PersonResponse> list(@RequestParam("page") int page,
                                                     @RequestParam("size") int size){
        var personList = personMapper.toPersonResponseList(listPersonUseCase.execute(page, size));
        for (final PersonResponse person : personList) {
            Link selfLink = linkTo(methodOn(PersonController.class)
                    .findById(person.getId())).withSelfRel();
            person.add(selfLink);
        }

        Link link = linkTo(methodOn(PersonController.class)
                .list(page, size)).withSelfRel();
        CollectionModel<PersonResponse> result = CollectionModel.of(personList, link);
        return result;
    }

    @GetMapping(value = "/{id}")
    public PersonResponse findById(@PathVariable String id){
        return personMapper.toPersonResponse(findPersonByIdUseCase.execute(id));
    }

    @PostMapping
    public ResponseEntity<Person> create( @RequestHeader("Idempotency-Key") String key,
                         @Valid @RequestBody PersonRequest personRequest){

        boolean existsIdempotency = idempotencyValidator.execute(key);
        if(existsIdempotency) {
            log.debug("idempotency-key already used, duplicated request detected: {}", key);

            return ResponseEntity
                    .noContent()
                    .build();
        }

        Person person = createPersonUseCase.execute(personMapper.fromPersonRequest(personRequest));

        idempotencyKeyUseCase.execute(key, personRequest.hashCode(),
                linkTo(methodOn(PersonController.class)
                        .create(key, personRequest)).withSelfRel().getHref());

        return ResponseEntity
                .created(linkTo(methodOn(PersonController.class)
                        .findById(person.getId())).withSelfRel().toUri())
                .body(person);
    }

    @PutMapping(value = "/{id}")
    public Person update( @RequestHeader("Idempotency-Key") String key,
                          @PathVariable String id,
                          @Valid @RequestBody PersonRequest personRequest){
        return updatePersonUseCase.execute(id, personMapper.fromPersonRequest(personRequest));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id){
        deletePersonUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
