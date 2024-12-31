package com.fita.taskmanagement.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TeamInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamId;
	private String teamName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="team_id")
	private List<EmployeeInfo> teamEmployees;
	
	@OneToOne
	@JoinColumn(name="LeadId")
	private TeamLead teamLead;
	
	@ElementCollection
	private List<String> technologies;
	
	
	public TeamInfo() {
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

	public List<EmployeeInfo> getTeamEmployees() {
		return teamEmployees;
	}

	public void setTeamEmployees(List<EmployeeInfo> teamEmployees) {
		this.teamEmployees = teamEmployees;
	}

	public TeamLead getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(TeamLead teamLead) {
		this.teamLead = teamLead;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	

}
