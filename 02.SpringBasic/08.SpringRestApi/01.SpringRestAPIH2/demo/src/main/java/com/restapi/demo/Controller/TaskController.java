package com.restapi.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.DTO.TaskRequestDTO;
import com.restapi.demo.DTO.TaskResponseDTO;
import com.restapi.demo.Service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO dto) {
        return service.createTask(dto);
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTask(@PathVariable Long id) {
        return service.getTask(id);
    }

}
