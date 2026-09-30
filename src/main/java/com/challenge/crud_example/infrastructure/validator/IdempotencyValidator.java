package com.challenge.crud_example.infrastructure.validator;

import com.challenge.crud_example.businessrule.gateway.IdempotencyKeyGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IdempotencyValidator {
    private final IdempotencyKeyGateway gateway;

    public boolean execute(String idempotencyKey) {
        return gateway.idempotencyKeyExists(idempotencyKey);
    }
}
