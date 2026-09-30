package com.challenge.crud_example.application.usecase;

import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.IdempotencyKeyGateway;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import com.challenge.crud_example.businessrule.usecase.SaveIdempotencyKeyUseCase;
import com.challenge.crud_example.businessrule.usecase.UpdatePersonUseCase;
import com.challenge.crud_example.infrastructure.repository.entity.IdempotencyKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveIdempotencyKeyUseCaseImpl implements SaveIdempotencyKeyUseCase {
    private final IdempotencyKeyGateway gateway;

    @Override
    public IdempotencyKey execute(String key, int requestHash, String endpoint) {
        return gateway.save(key, requestHash, endpoint);
    }
}
