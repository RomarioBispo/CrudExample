package com.challenge.crud_example.application.usecase;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.businessrule.usecase.FindPersonByIdUseCase;
import com.challenge.crud_example.businessrule.usecase.ListPersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPersonByIdUseCaseImpl implements FindPersonByIdUseCase {
    private final PersonGateway gateway;

    @Override
    public Person execute(String id) {
        //TODO: validate ID
        return gateway.findById(id);
    }
}
