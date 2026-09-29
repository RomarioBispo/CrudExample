package com.challenge.crud_example.infrastructure.gateway;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.infrastructure.mapper.PersonMapper;
import com.challenge.crud_example.infrastructure.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
