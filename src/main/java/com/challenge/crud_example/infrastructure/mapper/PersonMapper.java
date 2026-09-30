package com.challenge.crud_example.infrastructure.mapper;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.infrastructure.controller.request.PersonRequest;
import com.challenge.crud_example.infrastructure.controller.response.PersonResponse;
import com.challenge.crud_example.infrastructure.repository.entity.PersonEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    List<PersonResponse> toPersonResponseList(List<Person> person);
    PersonResponse toPersonResponse(Person person);
    List<Person> toPersonList(List<PersonEntity> personEntityList);
    Person toPerson(PersonEntity personEntity);
    PersonEntity toPersonEntity(Person person);
    Person fromPersonRequest(PersonRequest request);
}
