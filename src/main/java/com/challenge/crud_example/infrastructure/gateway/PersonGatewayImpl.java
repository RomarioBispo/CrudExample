package com.challenge.crud_example.infrastructure.gateway;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.infrastructure.exception.ResourceNotFoundException;
import com.challenge.crud_example.infrastructure.mapper.PersonMapper;
import com.challenge.crud_example.infrastructure.repository.PersonRepository;
import com.challenge.crud_example.infrastructure.repository.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonGatewayImpl implements PersonGateway {
    private final PersonRepository repository;
    private final PersonMapper personMapper;

    @Override
    public List<Person> list(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
         var persons = repository.findAll(pageable);
         return personMapper.toPersonList(persons.getContent());
    }

    @Override
    public Person findById(String id) {
        Optional<PersonEntity> personEntity = repository.findById(id);
        if(personEntity.isPresent()){
            return personMapper.toPerson(personEntity.get());
        }
        throw new ResourceNotFoundException("Resource Not Found");
    }

    @Override
    public Person create(Person person) {
        PersonEntity personEntity = personMapper.toPersonEntity(person);
        PersonEntity savedEntity = repository.save(personEntity);
        return personMapper.toPerson(savedEntity);
    }

    @Override
    //TODO: is this id really necessary?
    public Person update(String id, Person person) {
        findById(id);
        PersonEntity saved = repository.save(personMapper.toPersonEntity(person));
        return personMapper.toPerson(saved);
    }

    @Override
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
