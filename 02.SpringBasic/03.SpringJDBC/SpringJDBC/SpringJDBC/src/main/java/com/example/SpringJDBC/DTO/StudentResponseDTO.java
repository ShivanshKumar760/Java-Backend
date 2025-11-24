package com.example.SpringJDBC.DTO;

public class StudentResponseDTO {
    private int id;
    private String name;
    private int age;

    public StudentResponseDTO(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
}
