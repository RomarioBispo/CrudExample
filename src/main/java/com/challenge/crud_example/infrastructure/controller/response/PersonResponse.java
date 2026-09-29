package com.challenge.crud_example.infrastructure.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PersonResponse {
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String email;
    private PageMetaData meta;
}
