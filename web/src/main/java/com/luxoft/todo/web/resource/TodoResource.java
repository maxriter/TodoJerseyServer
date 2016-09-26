package com.luxoft.todo.web.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.luxoft.todo.api.FilterDto;
import com.luxoft.todo.api.TodoService;
import com.luxoft.todo.api.model.TodoTransmittedDto;

@Component
@Path("/todo")
public class TodoResource {

	@Autowired
	TodoService todoService;

	@GET
	@Path("/item")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TodoTransmittedDto> getAllTodo() {
		return todoService.getAll();
	}

	@PUT
	@Path("/item")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<TodoTransmittedDto> updateTodo(@RequestBody TodoTransmittedDto todoTransmittedDto) {
		todoService.update(todoTransmittedDto);
		return todoService.getAll();
	}

	@POST
	@Path("/filter")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<TodoTransmittedDto> searchTodo(@RequestBody FilterDto filter) {
		return todoService.searchByFilter(filter);
	}

	@POST
	@Path("/item")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TodoTransmittedDto addTodo(@RequestBody TodoTransmittedDto todoTransmittedDto) {
		return todoService.save(todoTransmittedDto);
	}

	@DELETE
	@Path("/item/{todoId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<TodoTransmittedDto> removeTodo(@PathParam("todoId") Long todoId) {
		todoService.remove(todoId);
		return todoService.getAll();
	}
}
