package com.fita.taskmanagement.bean;

import java.util.List;

public class ProjectInfoDTO {
	private Integer projectId;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	private String projectName;
	private List<Integer> taskIds;
	private List<Integer> employeeIds;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Integer> getTaskIds() {
		return taskIds;
	}
	public void setTaskIds(List<Integer> taskIds) {
		this.taskIds = taskIds;
	}
	public List<Integer> getEmployeeIds() {
		return employeeIds;
	}
	public void setEmployeeIds(List<Integer> employeeIds) {
		this.employeeIds = employeeIds;
	}
	
	

}
