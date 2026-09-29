package com.challenge.crud_example.businessrule.gateway;

import com.challenge.crud_example.businessrule.domain.entity.Person;

import java.util.List;

public interface PersonGateway {
    List<Person> list();
}
