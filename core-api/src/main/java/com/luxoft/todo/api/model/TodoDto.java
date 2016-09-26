package com.luxoft.todo.api.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDto {

    private Long id;
    private String todo;
    private LocalDateTime dateTime;

}
