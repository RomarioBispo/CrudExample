package com.challenge.crud_example.infrastructure.repository.entity;

import jakarta.persistence.Column;
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
@Entity(name="person")
public class PersonEntity {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String email;
    private String cpf;
}
