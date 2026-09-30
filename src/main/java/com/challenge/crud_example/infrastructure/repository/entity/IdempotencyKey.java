package com.challenge.crud_example.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "idempotency_keys"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdempotencyKey {

    @Id
    @Column(nullable = false, unique = true)
    private String key;

    @Column(nullable = false)
    private String endpoint;

    @Column(nullable = false)
    private int requestHash;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}