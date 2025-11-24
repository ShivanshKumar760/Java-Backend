package com.example.SpringJDBC.Service;

import com.example.SpringJDBC.DTO.StudentRequestDTO;
import com.example.SpringJDBC.DTO.StudentResponseDTO;
import com.example.SpringJDBC.Repository.StudentRepository;
import com.example.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDTO dto){//here dto will come from controller
        Student s = new Student(0, dto.getName(), dto.getAge());//we will convert it into
        //Student object
        studentRepository.add(s);
        return "Student Added Successfully!";
    }

    public List<StudentResponseDTO> getAllStudents() {//we will send the StudentResponseDTO to controller
        return studentRepository.getAll()
                .stream()
                .map(s -> new StudentResponseDTO(s.getId(), s.getName(), s.getAge()))
                .toList();
    }
}
