package com.fita.taskmanagement.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
@Entity
public class ProjectInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	private String projectName;
	
	@OneToMany
	@JoinColumn(name="projectId")
	private List<TaskInfo> taskList;
	
	@ManyToMany
	@JoinTable(name="project_employee",
	joinColumns=@JoinColumn(name="project_id"),inverseJoinColumns=@JoinColumn(name="employee_id"))
	private List<EmployeeInfo> employeeList;
	
	public ProjectInfo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<TaskInfo> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskInfo> taskList) {
		this.taskList = taskList;
	}

	public List<EmployeeInfo> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeInfo> employeeList) {
		this.employeeList = employeeList;
	}

	public ProjectInfo(Integer projectId, String projectName, List<TaskInfo> taskList,
			List<EmployeeInfo> employeeList) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.taskList = taskList;
		this.employeeList = employeeList;
	}
}
