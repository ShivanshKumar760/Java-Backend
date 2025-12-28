package com.restapi.demo.Mapper;

import com.restapi.demo.DTO.TaskRequestDTO;
import com.restapi.demo.DTO.TaskResponseDTO;
import com.restapi.demo.Model.TaskEntity;

public class TaskMapper {
	public static TaskEntity toEntity(TaskRequestDTO reqDTO) {
		TaskEntity entity = new TaskEntity();
		entity.setTaskName(reqDTO.getTaskName());
		entity.setDescription(reqDTO.getDescription());
		return entity;
	}
	
	public static TaskResponseDTO toDTO(TaskEntity entity) {
		TaskResponseDTO response = new TaskResponseDTO();
		response.setId(entity.getId());
		response.setTaskName(entity.getTaskName());
		response.setDescription(entity.getDescription());
		return response;
	}
}
