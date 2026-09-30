package com.challenge.crud_example.infrastructure.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PersonRequest ( @NotBlank(message = "Name is mandatory") String name,
                              @NotNull(message = "birthDate is mandatory") LocalDate birthDate,
                              @NotBlank(message = "cpf is mandatory") String cpf,
                             String email) {
}
