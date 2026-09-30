package com.challenge.crud_example.businessrule.domain.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String email;
}
