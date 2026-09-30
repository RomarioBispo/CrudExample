package com.challenge.crud_example.infrastructure.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PersonResponse extends RepresentationModel<PersonResponse> {
    private String id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String email;
}
