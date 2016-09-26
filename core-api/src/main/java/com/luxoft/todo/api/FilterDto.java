package com.luxoft.todo.api;

import lombok.Data;

@Data
public class FilterDto {

    Long id;
    String todo;
    String dateFrom;
    String dateTo;

}
