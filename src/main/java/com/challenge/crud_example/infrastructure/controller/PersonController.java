package com.challenge.crud_example.infrastructure.controller;

import com.challenge.crud_example.businessrule.usecase.ListPersonUseCase;
import com.challenge.crud_example.infrastructure.controller.response.PersonResponse;
import com.challenge.crud_example.infrastructure.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons/v1")
@RequiredArgsConstructor
public class PersonController {
    private final PersonMapper personMapper;
    private final ListPersonUseCase listPersonUseCase;

    //TODO: converter personresponse para record
    //TODO: adicionar script de migration
    @GetMapping(value = "/persons")
    public Page<PersonResponse> list(){
        var personList = listPersonUseCase.execute();
        return new PageImpl(personMapper.toPersonResponse(personList));
    }
}
