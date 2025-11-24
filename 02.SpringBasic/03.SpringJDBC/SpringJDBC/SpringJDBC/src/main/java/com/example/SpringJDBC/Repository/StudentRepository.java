package com.example.SpringJDBC.Repository;
import com.example.SpringJDBC.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;
    public StudentRepository(JdbcTemplate template){
        this.jdbcTemplate=template;
    }

    public int add(Student s){
        return jdbcTemplate.update(
                "INSERT INTO student(name, age) VALUES (?, ?)",
                s.getName(), s.getAge() ljmhb X
        );
    }
    public List<Student> getAll() {
        RowMapper<Student> mapper=new RowMapper<Student>(){
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
            }
        };
        return jdbcTemplate.query("SELECT * from Student",mapper);
    }
}
