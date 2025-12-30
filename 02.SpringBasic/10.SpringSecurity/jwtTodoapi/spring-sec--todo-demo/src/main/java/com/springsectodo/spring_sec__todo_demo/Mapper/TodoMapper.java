package com.springsectodo.spring_sec__todo_demo.Mapper;

import com.springsectodo.spring_sec__todo_demo.DTO.TodoRequestDTO;
import com.springsectodo.spring_sec__todo_demo.DTO.TodoResponseDTO;
import com.springsectodo.spring_sec__todo_demo.TodoEntity.Todo;
import com.springsectodo.spring_sec__todo_demo.UserEntity.User;

public class TodoMapper {
    public static Todo toEntity(TodoRequestDTO dto, User user) {
        Todo todo = new Todo();
        todo.setTodo(dto.getTodo());
        todo.setDescription(dto.getDescription());
        todo.setUser(user);
        return todo;
    }

    public static TodoResponseDTO toDTO(Todo todo) {
        return new TodoResponseDTO(
                todo.getId(),
                todo.getTodo(),
                todo.getDescription()
        );
    }
}
