package com.luxoft.todo.api.model;

import lombok.Data;

@Data
public class TodoTransmittedDto {

	private Long id;
	private String todo;
	private Long dateTime;

}