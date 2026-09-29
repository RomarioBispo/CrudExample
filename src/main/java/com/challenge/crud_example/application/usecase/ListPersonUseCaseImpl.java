package com.challenge.crud_example.application.usecase;

import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.businessrule.usecase.ListPersonUseCase;
import com.challenge.crud_example.businessrule.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListPersonUseCaseImpl implements ListPersonUseCase {
    private final PersonGateway gateway;

    @Override
    public List<Person> execute(int page, int size) {
        return gateway.list(page, size);
    }
}
