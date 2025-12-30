package com.springsectodo.spring_sec__todo_demo.DTO;

public class TodoResponseDTO {
    private final Long id;
    private final String todo;
    private final String description;
    public TodoResponseDTO(Long id, String todo, String description) {
        this.id = id;
        this.todo = todo;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getTodo() { return todo; }
    public String getDescription() { return description; }

}
