package com.example.studentmanagementapi.Mapper;

import com.example.studentmanagementapi.DTO.StudentRequestDTO;
import com.example.studentmanagementapi.DTO.StudentResponseDTO;
import com.example.studentmanagementapi.Model.StudentEntity;

public class StudentMapper {

	public static StudentEntity toEntity(StudentRequestDTO reqDTO) {
		StudentEntity entity=new StudentEntity();
		entity.setRollNumber(reqDTO.getRollNumber());
		entity.setAge(reqDTO.getAge());
		entity.setFname(reqDTO.getFname());
		entity.setLname(reqDTO.getLname());
		entity.setClassGrade(reqDTO.getClassGrade());
		
		return entity;
	}
	
	public static StudentResponseDTO toDTO(StudentEntity entity) {
		  StudentResponseDTO dto = new StudentResponseDTO();

	        dto.setId(entity.getId());
	        dto.setRollNumber(entity.getRollNumber());
	        dto.setAge(entity.getAge());
	        dto.setFname(entity.getFname());
	        dto.setLname(entity.getLname());
	        dto.setClassGrade(entity.getClassGrade());

	        return dto;
		
	}
}
