package com.challenge.crud_example.usecase;

import com.challenge.crud_example.application.usecase.SaveIdempotencyKeyUseCaseImpl;
import com.challenge.crud_example.businessrule.gateway.IdempotencyKeyGateway;
import com.challenge.crud_example.infrastructure.repository.entity.IdempotencyKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveIdempotencyKeyUseCaseTest {

    @Mock
    private IdempotencyKeyGateway idempotencyKeyGateway;

    @InjectMocks
    private SaveIdempotencyKeyUseCaseImpl saveIdempotencyKeyUseCase;

    @Test
    void shouldSaveIdempotencyKeyWhenValidParameters() {
        String key = UUID.randomUUID().toString();
        int requestHash = 123456;
        String endpoint = "/api/v1/persons";

        IdempotencyKey mockIdempotencyKey = IdempotencyKey.builder()
                .key(key)
                .requestHash(requestHash)
                .endpoint(endpoint)
                .build();

        when(idempotencyKeyGateway.save(key, requestHash, endpoint))
                .thenReturn(mockIdempotencyKey);

        IdempotencyKey result = saveIdempotencyKeyUseCase.execute(key, requestHash, endpoint);

        assertNotNull(result);
        assertEquals(key, result.getKey());
        assertEquals(requestHash, result.getRequestHash());
        assertEquals(endpoint, result.getEndpoint());
        verify(idempotencyKeyGateway).save(key, requestHash, endpoint);
    }
}