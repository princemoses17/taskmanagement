package com.fita.taskmanagement.bean;

import java.util.List;

public class TeamLeadDTO {
     private Integer teamLeadId;
     private Integer employeeId;
     private List<Integer> teamMembers;
     private List<Integer> projectIds;
     
     
	public Integer getTeamLeadId() {
		return teamLeadId;
	}
	public void setTeamLeadId(Integer teamLeadId) {
		this.teamLeadId = teamLeadId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public List<Integer> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<Integer> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public List<Integer> getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(List<Integer> projectIds) {
		this.projectIds = projectIds;
	}
     
     
}
