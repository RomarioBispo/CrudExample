package com.challenge.crud_example.application.usecase;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.businessrule.usecase.FindPersonByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPersonByIdUseCaseImpl implements FindPersonByIdUseCase {
    private final PersonGateway gateway;

    @Override
    public Person execute(String id) {
        return gateway.findById(id);
    }
}
