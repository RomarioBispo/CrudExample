package com.challenge.crud_example.infrastructure.controller;

import com.challenge.crud_example.businessrule.usecase.ListPersonUseCase;
import com.challenge.crud_example.infrastructure.controller.response.PersonResponse;
import com.challenge.crud_example.infrastructure.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/persons/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonMapper personMapper;
    private final ListPersonUseCase listPersonUseCase;

    //TODO: converter personresponse para record
    @GetMapping
    public CollectionModel<PersonResponse> list(@RequestParam("page") int page,
                                                     @RequestParam("size") int size){
        var personList = personMapper.toPersonResponse(listPersonUseCase.execute(page, size));

        Link link = linkTo(methodOn(PersonController.class)
                .list(page, size)).withSelfRel();

        CollectionModel<PersonResponse> result = CollectionModel.of(personList, link);
        return result;
    }

    @GetMapping(value = "/{id}")
    public CollectionModel<PersonResponse> findById(@PathVariable String id){
        return CollectionModel.empty();
    }
}
