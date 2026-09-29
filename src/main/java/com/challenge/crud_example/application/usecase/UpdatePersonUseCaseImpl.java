package com.challenge.crud_example.application.usecase;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.businessrule.usecase.CreatePersonUseCase;
import com.challenge.crud_example.businessrule.usecase.UpdatePersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {
    private final PersonGateway gateway;

    @Override
    public Person execute(String id, Person person) {
        return gateway.update(id, person);
    }
}
