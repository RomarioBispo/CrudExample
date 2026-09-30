package com.challenge.crud_example.usecase;

import com.challenge.crud_example.application.usecase.UpdatePersonUseCaseImpl;
import com.challenge.crud_example.businessrule.domain.entity.Person;
import com.challenge.crud_example.businessrule.gateway.PersonGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdatePersonUseCaseTest {

    @Mock
    private PersonGateway personGateway;

    @InjectMocks
    private UpdatePersonUseCaseImpl updatePersonUseCase;

    @Test
    void shouldUpdatePersonWhenValidData() {
        // Arrange
        String id = UUID.randomUUID().toString();

        Person mockPerson = Person.builder()
                .id(id)
                .name("Updated Name")
                .birthDate(LocalDate.now())
                .email("updated@mail.com")
                .cpf("12345678900")
                .build();

        when(personGateway.update(id, mockPerson))
                .thenReturn(mockPerson);

        Person result = updatePersonUseCase.execute(id, mockPerson);

        assertEquals("Updated Name", result.getName());
        assertEquals("updated@mail.com", result.getEmail());
        verify(personGateway).update(id, mockPerson);
    }
}