package com.challenge.crud_example.infrastructure.mapper;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.infrastructure.controller.response.PersonResponse;
import com.challenge.crud_example.infrastructure.repository.entity.PersonEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    List<PersonResponse> toPersonResponse(List<Person> person);
    List<Person> toPersonList(List<PersonEntity> personEntityList);
}
