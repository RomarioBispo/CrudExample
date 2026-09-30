package com.challenge.crud_example.usecase;

import com.challenge.crud_example.application.usecase.CreatePersonUseCaseImpl;
import com.challenge.crud_example.application.usecase.FindPersonByIdUseCaseImpl;
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
class PersonUseCaseTest {
    @Mock
    private PersonGateway personGateway;

    @InjectMocks
    private FindPersonByIdUseCaseImpl findPersonByIdUseCase;

    @InjectMocks
    private CreatePersonUseCaseImpl createPersonUseCase;

    @Test
    void shouldReturnPersonWhenIdExists() {
        String id = UUID.randomUUID().toString();

        Person mockPerson = Person.builder()
                .id(id)
                .name("NAME")
                .birthDate(LocalDate.now())
                .email("mail@mail.com")
                .cpf("12345678900")
                .build();

        when(personGateway.findById(id))
                .thenReturn(mockPerson);

        Person result = findPersonByIdUseCase.execute(id);

        assertEquals("NAME", result.getName());
        verify(personGateway).findById(id);
    }

    @Test
    void shouldCreatePersonWhenValidData() {
        String id = UUID.randomUUID().toString();

        Person mockPerson = Person.builder()
                .id(id)
                .name("NAME")
                .birthDate(LocalDate.now())
                .email("mail@mail.com")
                .cpf("12345678900")
                .build();

        when(personGateway.create(mockPerson))
                .thenReturn(mockPerson);

        Person result = createPersonUseCase.execute(mockPerson);

        assertEquals("NAME", result.getName());
        verify(personGateway).findById(id);
    }
}
