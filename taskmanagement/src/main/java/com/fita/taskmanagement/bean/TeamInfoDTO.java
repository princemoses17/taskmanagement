package com.fita.taskmanagement.bean;

import java.util.List;

public class TeamInfoDTO {
	private Integer teamId;
	private String teamName;
	private Integer teamLeadId;
	private List<Integer> teamEmployeeIds;
	private List<String> technologies;

	public TeamInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Integer> getTeamEmployeeIds() {
		return teamEmployeeIds;
	}

	public void setTeamEmployeeIds(List<Integer> teamEmployeeIds) {
		this.teamEmployeeIds = teamEmployeeIds;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	public Integer getTeamLeadId() {
		return teamLeadId;
	}

	public void setTeamLeadId(Integer teamLeadId) {
		this.teamLeadId = teamLeadId;
	}
	
}
