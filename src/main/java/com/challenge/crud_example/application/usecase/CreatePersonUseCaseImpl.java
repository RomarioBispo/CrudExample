package com.challenge.crud_example.application.usecase;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.businessrule.usecase.CreatePersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePersonUseCaseImpl implements CreatePersonUseCase {
    private final PersonGateway gateway;

    @Override
    public Person execute(Person person) {
        return gateway.create(person);
    }
}
