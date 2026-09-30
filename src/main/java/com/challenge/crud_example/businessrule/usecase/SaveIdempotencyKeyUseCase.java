package com.challenge.crud_example.businessrule.usecase;

import com.challenge.crud_example.infrastructure.repository.entity.IdempotencyKey;

public interface SaveIdempotencyKeyUseCase {
   IdempotencyKey execute(String key, int requestHash, String endpoint);
}
