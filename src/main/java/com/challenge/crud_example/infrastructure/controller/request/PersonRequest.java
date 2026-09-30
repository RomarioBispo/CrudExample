package com.challenge.crud_example.infrastructure.controller.request;

import java.time.LocalDate;

public record PersonRequest (String name,
                             LocalDate birthDate,
                             String cpf,
                             String email) {
}
