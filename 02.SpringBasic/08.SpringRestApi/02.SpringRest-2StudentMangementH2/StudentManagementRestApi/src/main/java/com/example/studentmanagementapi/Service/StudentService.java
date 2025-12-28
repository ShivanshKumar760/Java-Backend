package com.example.studentmanagementapi.Service;

import com.example.studentmanagementapi.DTO.StudentRequestDTO;
import com.example.studentmanagementapi.DTO.StudentResponseDTO;
import com.example.studentmanagementapi.Mapper.StudentMapper;
import com.example.studentmanagementapi.Model.StudentEntity;
import com.example.studentmanagementapi.Repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class StudentService {

	private final StudentRepository repo;
	
	public StudentService(StudentRepository repo) {
		this.repo=repo;
	}
	
	//create
	public String createStudent(StudentRequestDTO reqDTO) {
		StudentEntity entity=StudentMapper.toEntity(reqDTO);
		repo.save(entity);
		return "StudentCreated";
	}
	
	//get student by id 
	
	public StudentResponseDTO getById(long id) {
		StudentEntity entity = repo.findById(id);
		return StudentMapper.toDTO(entity);
		
	}
	
	public List<StudentResponseDTO> getAllStudents() {
		
		return repo.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
        
    }

    // ✅ GET BY ROLL NUMBER
    public StudentResponseDTO getStudentByRollNumber(int rollNumber) {
        StudentEntity entity = repo.findByRollNumber(rollNumber);
        return StudentMapper.toDTO(entity);
    }
	
}
