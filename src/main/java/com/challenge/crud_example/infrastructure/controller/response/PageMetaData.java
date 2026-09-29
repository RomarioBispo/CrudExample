package com.challenge.crud_example.infrastructure.controller.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageMetaData {
    private Integer pageNumber;
    private Integer numberOfPage;
    private Integer totalRecords;
}
