package com.restapi.demo.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.restapi.demo.Model.TaskEntity;

import org.springframework.jdbc.core.*;

@Repository
public class TaskRepository {
	private final JdbcTemplate jdbcTemplate;
	public TaskRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
    private final RowMapper<TaskEntity> rowMapper = (rs, rowNum) -> {
    		TaskEntity task = new TaskEntity();
        task.setId(rs.getLong("id"));
        task.setTaskName(rs.getString("taskName"));
        task.setDescription(rs.getString("description"));
        return task;
    };
    
    public int save(TaskEntity task) {
        return jdbcTemplate.update(
            "INSERT INTO tasks(taskName, description) VALUES (?, ?)",
            task.getTaskName(),
            task.getDescription()
        );
    }

    public TaskEntity findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM tasks WHERE id = ?",
            rowMapper,
            id
        );
    }

	
}
