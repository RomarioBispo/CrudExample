package com.challenge.crud_example.infrastructure.controller.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse ( LocalDateTime timestamp,
                              String msg,
                              HttpStatus status) {
}
