package com.restapi.demo.DTO;

public class TaskResponseDTO {

	private Long id;
	private String taskName;
	private String description;
	
	public Long getId() {
		return this.id;
	}
	
	
	public String getTaskName() {
		return this.taskName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public void setTaskName(String taskName) {
		this.taskName=taskName;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}

}
