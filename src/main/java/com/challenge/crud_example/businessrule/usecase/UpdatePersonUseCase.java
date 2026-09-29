package com.challenge.crud_example.businessrule.usecase;

import com.challenge.crud_example.businessrule.domain.entity.Person;

public interface UpdatePersonUseCase {
   Person execute(String id, Person person);
}
