package com.challenge.crud_example.businessrule.gateway;

import com.challenge.crud_example.businessrule.domain.entity.Person;

import java.util.List;

public interface PersonGateway {
    List<Person> list(int page, int size);
    Person findById(String id);
    Person create(Person person);
    Person update(String id, Person person);
    void delete(String id);
}
