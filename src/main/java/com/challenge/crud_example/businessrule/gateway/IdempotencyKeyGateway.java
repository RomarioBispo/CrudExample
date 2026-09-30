package com.challenge.crud_example.businessrule.gateway;

import com.challenge.crud_example.infrastructure.repository.entity.IdempotencyKey;

public interface IdempotencyKeyGateway {
     boolean idempotencyKeyExists(String key);
     IdempotencyKey save(String key, int requestHash, String endpoint);
}
