package com.javabackend.taskapi.controller;

import com.javabackend.taskapi.dto.CreateTaskDTO;
import com.javabackend.taskapi.entities.TaskEntity;
import com.javabackend.taskapi.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    //inject the task service
    private final TaskService taskService;
    TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    @GetMapping("/")
    public ResponseEntity<List<TaskEntity>> getTask(){
            var tasks=taskService.getTasks();
            return ResponseEntity.ok(tasks);
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id){
        var task=taskService.getTaskById(id);
        if(task==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("/")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body){
        var task=taskService.addTask(body.getTitle(),body.getDescription(), body.getDescription());
        return ResponseEntity.ok(task);
    }
}
