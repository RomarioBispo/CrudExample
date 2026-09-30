package com.challenge.crud_example.infrastructure.repository;

import com.challenge.crud_example.infrastructure.repository.entity.IdempotencyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdempotencyRepository extends JpaRepository<IdempotencyKey, String> {
}
