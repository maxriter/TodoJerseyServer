package com.luxoft.todo.api.converters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import com.luxoft.todo.api.model.TodoDto;
import com.luxoft.todo.api.model.TodoTransmittedDto;

public final class TodoConverter {
	public static TodoDto convertTransmittedDto(TodoTransmittedDto todoDto) {
		TodoDto convertedDto = new TodoDto();
		convertedDto.setId(todoDto.getId());
		convertedDto.setTodo(todoDto.getTodo());
		if (todoDto.getDateTime() != null) {
			convertedDto.setDateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(todoDto.getDateTime()), ZoneId.systemDefault()));
		}
		return convertedDto;
	}

	public static TodoTransmittedDto convertTodoDto(TodoDto todoDto) {
		TodoTransmittedDto convertedDto = new TodoTransmittedDto();
		convertedDto.setId(todoDto.getId());
		convertedDto.setTodo(todoDto.getTodo());
		if (todoDto.getDateTime() != null) {
			convertedDto.setDateTime(todoDto.getDateTime().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
		}
		return convertedDto;
	}

}
