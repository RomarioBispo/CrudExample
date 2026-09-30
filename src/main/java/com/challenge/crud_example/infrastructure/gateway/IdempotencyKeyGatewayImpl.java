package com.challenge.crud_example.infrastructure.gateway;

import com.challenge.crud_example.businessrule.gateway.IdempotencyKeyGateway;
import com.challenge.crud_example.infrastructure.mapper.PersonMapper;
import com.challenge.crud_example.infrastructure.repository.IdempotencyRepository;
import com.challenge.crud_example.infrastructure.repository.entity.IdempotencyKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class IdempotencyKeyGatewayImpl implements IdempotencyKeyGateway {
    private final IdempotencyRepository repository;
    private final PersonMapper personMapper;

    @Override
    public boolean idempotencyKeyExists(String key) {
        return repository.existsById(key);
    }

    @Override
    public IdempotencyKey save(String key, int requestHash, String endpoint) {
        IdempotencyKey idempotencyKey = IdempotencyKey.builder()
                .key(key)
                .endpoint(endpoint)
                .requestHash(requestHash)
                .createdAt(LocalDateTime.now())
                .build();
        return repository.save(idempotencyKey);
    }
}
