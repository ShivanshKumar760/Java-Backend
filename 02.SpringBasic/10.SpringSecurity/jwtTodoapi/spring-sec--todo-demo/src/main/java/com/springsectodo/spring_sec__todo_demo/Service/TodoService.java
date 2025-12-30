package com.springsectodo.spring_sec__todo_demo.Service;

import com.springsectodo.spring_sec__todo_demo.DTO.TodoRequestDTO;
import com.springsectodo.spring_sec__todo_demo.DTO.TodoResponseDTO;
import com.springsectodo.spring_sec__todo_demo.Mapper.TodoMapper;
import com.springsectodo.spring_sec__todo_demo.Repository.TodoRepository;
import com.springsectodo.spring_sec__todo_demo.TodoEntity.Todo;
import com.springsectodo.spring_sec__todo_demo.UserEntity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDTO createTodo(TodoRequestDTO dto, User user) {
        Todo todo = TodoMapper.toEntity(dto,user);
        todoRepository.save(todo);
        return TodoMapper.toDTO(todo);
    }

    public List<TodoResponseDTO> getTodos(User user) {
        return todoRepository.findByUserUsername(user.getUsername())
                .stream()
                .map(TodoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
