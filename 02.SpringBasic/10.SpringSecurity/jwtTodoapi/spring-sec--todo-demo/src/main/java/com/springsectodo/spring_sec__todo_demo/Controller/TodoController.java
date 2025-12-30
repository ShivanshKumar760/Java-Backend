package com.springsectodo.spring_sec__todo_demo.Controller;


import com.springsectodo.spring_sec__todo_demo.DTO.TodoRequestDTO;
import com.springsectodo.spring_sec__todo_demo.DTO.TodoResponseDTO;
import com.springsectodo.spring_sec__todo_demo.Service.TodoService;
import com.springsectodo.spring_sec__todo_demo.Service.UserService;
import com.springsectodo.spring_sec__todo_demo.UserEntity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

        private final TodoService todoService;
        private final UserService userService;

        public TodoController(TodoService todoService, UserService userService) {
            this.todoService = todoService;
            this.userService = userService;
        }

        @PostMapping
        public TodoResponseDTO createTodo(@RequestBody TodoRequestDTO dto, Authentication auth) {
            User user = userService.getUserEntity(auth.getName());
            return todoService.createTodo(dto, user);
        }

        @GetMapping
        public List<TodoResponseDTO> getTodos(Authentication auth) {
            User user = userService.getUserEntity(auth.getName());
            return todoService.getTodos(user);
        }
    }

