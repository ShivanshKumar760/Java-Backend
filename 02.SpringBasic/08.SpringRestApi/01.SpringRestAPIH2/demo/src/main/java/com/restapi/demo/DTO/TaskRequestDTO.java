package com.restapi.demo.DTO;

public class TaskRequestDTO {
	private String taskName;
	private String description;
	
	public String getTaskName() {
		return this.taskName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setTaskName(String taskName) {
		this.taskName=taskName;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}

}
