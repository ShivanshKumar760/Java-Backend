package com.example.studentmanagementapi.Repository;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import com.example.studentmanagementapi.Model.StudentEntity;

import java.util.List;

@Repository
public class StudentRepository {
	public final JdbcTemplate jdbcTemplate;
	
	public StudentRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	
	 private final RowMapper<StudentEntity> rowMapper = (rs, rowNum) -> {
	        StudentEntity student = new StudentEntity();
	        student.setId(rs.getInt("id"));
	        student.setRollNumber(rs.getInt("rollNumber"));
	        student.setAge(rs.getInt("age"));
	        student.setFname(rs.getString("fname"));
	        student.setLname(rs.getString("lname"));
	        student.setClassGrade(rs.getString("classGrade"));
	        return student;
	    };

	    // CREATE
	    public int save(StudentEntity student) {
	        return jdbcTemplate.update(
	            "INSERT INTO students (rollNumber, age, fname, lname, classGrade) VALUES (?, ?, ?, ?, ?)",
	            student.getRollNumber(),
	            student.getAge(),
	            student.getFname(),
	            student.getLname(),
	            student.getClassGrade()
	        );
	    }

	    // GET BY ID
	    public StudentEntity findById(long id) {
	        return jdbcTemplate.queryForObject(
	            "SELECT * FROM students WHERE id = ?",
	            rowMapper,
	            id
	        );
	    }

	    // ✅ GET ALL
	    public List<StudentEntity> findAll() {
	        return jdbcTemplate.query(
	            "SELECT * FROM students",
	            rowMapper
	        );
	    }

	    // ✅ GET BY ROLL NUMBER
	    public StudentEntity findByRollNumber(int rollNumber) {
	        return jdbcTemplate.queryForObject(
	            "SELECT * FROM students WHERE rollNumber = ?",
	            rowMapper,
	            rollNumber
	        );
	    }
	

}
