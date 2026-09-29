package com.challenge.crud_example.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tb_person")
public class PersonEntity {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private LocalDate birthdate;
    private String cpf;
}
