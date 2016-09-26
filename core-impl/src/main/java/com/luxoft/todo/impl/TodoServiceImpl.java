package com.luxoft.todo.impl;

import com.luxoft.todo.api.FilterDto;
import com.luxoft.todo.api.TodoService;
import com.luxoft.todo.api.converters.TodoConverter;
import com.luxoft.todo.api.converters.TodoListConverter;
import com.luxoft.todo.api.model.TodoTransmittedDto;
import com.luxoft.todo.dao.TodoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoDao todoDao;

	@Override
	public List<TodoTransmittedDto> getAll() {
		return TodoListConverter.convertToTodoTransmittedDtoList(todoDao.getAll());
	}

	@Override
	public TodoTransmittedDto save(TodoTransmittedDto todoTransmittedDto) {
		return TodoConverter.convertTodoDto(todoDao.save(TodoConverter.convertTransmittedDto(todoTransmittedDto)));
	}

	@Override
	public void remove(Long id) {
		todoDao.remove(id);
	}

	@Override
	public void update(TodoTransmittedDto todoTransmittedDto) {
		todoDao.update(TodoConverter.convertTransmittedDto(todoTransmittedDto));
	}

	@Override
	public List<TodoTransmittedDto> searchByFilter(FilterDto filter) {
		return TodoListConverter.convertToTodoTransmittedDtoList(todoDao.searchByFilter(filter));
	}

}
