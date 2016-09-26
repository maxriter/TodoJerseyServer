package com.luxoft.todo.api.converters;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.todo.api.model.TodoDto;
import com.luxoft.todo.api.model.TodoTransmittedDto;

public class TodoListConverter {

	public static List<TodoTransmittedDto> convertToTodoTransmittedDtoList(List<TodoDto> list) {
		List<TodoTransmittedDto> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			result.add(TodoConverter.convertTodoDto(list.get(i)));
		}
		return result;
	}
}
