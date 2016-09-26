package com.luxoft.todo.api;

import java.util.List;

import com.luxoft.todo.api.model.TodoTransmittedDto;

public interface TodoService {

    List<TodoTransmittedDto> getAll();

    TodoTransmittedDto save(TodoTransmittedDto TodoTransmittedDto);

    void remove(Long id);

    void update(TodoTransmittedDto todoTransmittedDto);

    List<TodoTransmittedDto> searchByFilter(FilterDto filter);
}
