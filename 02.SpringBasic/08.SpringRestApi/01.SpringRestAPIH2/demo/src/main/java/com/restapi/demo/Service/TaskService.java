package com.restapi.demo.Service;

import org.springframework.stereotype.Service;

import com.restapi.demo.DTO.TaskRequestDTO;
import com.restapi.demo.DTO.TaskResponseDTO;
import com.restapi.demo.Mapper.TaskMapper;
import com.restapi.demo.Model.TaskEntity;
import com.restapi.demo.Repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository repo;
	public TaskService(TaskRepository repo) {
		this.repo=repo;
	}
	
    public TaskResponseDTO createTask(TaskRequestDTO requestDto) {
        TaskEntity entity = TaskMapper.toEntity(requestDto);
        repo.save(entity);
        // H2 auto increments id, fetch again if needed
        return TaskMapper.toDTO(entity);
    }

    public TaskResponseDTO getTask(Long id) {
        TaskEntity entity = repo.findById(id);
        return TaskMapper.toDTO(entity);
    }
}
