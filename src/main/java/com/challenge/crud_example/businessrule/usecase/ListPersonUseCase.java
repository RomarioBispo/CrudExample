package com.challenge.crud_example.businessrule.usecase;

import com.challenge.crud_example.businessrule.domain.entity.Person;

import java.util.List;

public interface ListPersonUseCase {
    List<Person> execute(int page, int size);
}
