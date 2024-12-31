package com.fita.taskmanagement.bean;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TeamLead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamLeadId;

	@OneToOne
	@JoinColumn(name="employeeId")
	private EmployeeInfo employee;

	@OneToMany
	@JoinColumn(name="LeadId")
	private List<EmployeeInfo> teamMembers;

	@OneToMany
	@JoinColumn(name="LeadId")
	private List<ProjectInfo> projectList;

	public Integer getTeamLeadId() {
		return teamLeadId;
	}

	public void setTeamLeadId(Integer teamLeadId) {
		this.teamLeadId = teamLeadId;
	}

	public EmployeeInfo getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeInfo employee) {
		this.employee = employee;
	}

	public List<EmployeeInfo> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<EmployeeInfo> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public List<ProjectInfo> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectInfo> projectList) {
		this.projectList = projectList;
	}
	
	public TeamLead() {
		// TODO Auto-generated constructor stub
	}

}
