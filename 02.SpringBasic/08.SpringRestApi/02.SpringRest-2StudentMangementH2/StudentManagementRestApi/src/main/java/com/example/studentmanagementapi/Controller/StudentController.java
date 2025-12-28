package com.example.studentmanagementapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagementapi.DTO.StudentRequestDTO;
import com.example.studentmanagementapi.DTO.StudentResponseDTO;
import com.example.studentmanagementapi.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	
	private final StudentService service;
	public StudentController(StudentService service) {
		this.service=service;
	}
	
	@PostMapping
	public String createStudent(@RequestBody StudentRequestDTO reqDTO) {
		return service.createStudent(reqDTO);
	}
	
	
	@GetMapping("/{id}")
	public StudentResponseDTO getStudentById(@PathVariable long id) {
		return service.getById(id);
	}
	
	
	@GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return service.getAllStudents();
    }

    // ✅ GET BY ROLL NUMBER
    @GetMapping("/roll/{rollNumber}")
    public StudentResponseDTO getByRollNumber(@PathVariable int rollNumber) {
        return service.getStudentByRollNumber(rollNumber);
    }
	

}
