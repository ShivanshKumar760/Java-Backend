package com.example.SpringJDBC.controller;

import com.example.SpringJDBC.DTO.StudentRequestDTO;
import com.example.SpringJDBC.DTO.StudentResponseDTO;
import com.example.SpringJDBC.Repository.StudentRepository;
import com.example.SpringJDBC.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService sts;
    public StudentController(StudentService sts){
        this.sts=sts;
    }

    @PostMapping("/add")
    public String add(@RequestBody StudentRequestDTO dto) {
        return sts.addStudent(dto);
    }

    @GetMapping("/all")
    public List<StudentResponseDTO> getAll() {
        return sts.getAllStudents();
    }

}
