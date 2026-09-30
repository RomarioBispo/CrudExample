package com.challenge.crud_example.application.usecase;

import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.businessrule.usecase.DeletePersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePersonUseCaseImpl implements DeletePersonUseCase {
    private final PersonGateway gateway;

    @Override
    public void execute(String id) {
        gateway.delete(id);
    }
}
