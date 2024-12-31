package com.fita.taskmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.taskmanagement.bean.Company;
import com.fita.taskmanagement.bean.EmployeeInfo;
import com.fita.taskmanagement.bean.TaskInfo;
import com.fita.taskmanagement.bean.TeamInfo;
import com.fita.taskmanagement.bean.TeamInfoDTO;
import com.fita.taskmanagement.bean.TeamLead;
import com.fita.taskmanagement.repository.CompanyRepository;
import com.fita.taskmanagement.repository.EmployeeRepository;
import com.fita.taskmanagement.repository.TeamInfoRepository;
import com.fita.taskmanagement.repository.TeamLeadRepository;

@Service
public class TeamInfoService {
	@Autowired
	private TeamLeadRepository teamLeadRepository;

	@Autowired
	private EmployeeRepository employeeInfoRepository;

	@Autowired
	private TeamInfoRepository teamInfoRepository;

	public TeamInfo saveOrUpdateTeamInfo(TeamInfoDTO teamInfoRequest) {
		TeamLead teamLead = teamLeadRepository.findById(teamInfoRequest.getTeamLeadId())
				.orElseThrow(() -> new RuntimeException("TeamLead not found with ID: " + teamInfoRequest.getTeamLeadId()));

		List<EmployeeInfo> teamEmployees = employeeInfoRepository.findAllById(teamInfoRequest.getTeamEmployeeIds());

		TeamInfo teamInfo;
		if (teamInfoRequest.getTeamId() != null) {
			teamInfo = teamInfoRepository.findById(teamInfoRequest.getTeamId())
					.orElseThrow(() -> new RuntimeException("TeamInfo not found with ID: " + teamInfoRequest.getTeamId()));
		} else {
			teamInfo = new TeamInfo();
		}

		teamInfo.setTeamName(teamInfoRequest.getTeamName());
		teamInfo.setTeamLead(teamLead);
		teamInfo.setTeamEmployees(teamEmployees);
		teamInfo.setTechnologies(teamInfoRequest.getTechnologies());

		return teamInfoRepository.save(teamInfo);
	}


	public TeamInfo getByTeamName(String teamName){
		return teamInfoRepository.findAllByTeamName(teamName).get();
	}


	public List<TaskInfo> getTasksForAllEmployeesByTeamName(String teamName) {
		// Fetch the team by team name
		TeamInfo teamInfo = teamInfoRepository.findByTeamName(teamName)
				.orElseThrow(() -> new RuntimeException("Team not found with name: " + teamName));

		// Get all employees from the team
		List<EmployeeInfo> teamEmployees = teamInfo.getTeamEmployees();

		// Collect all tasks from each employee
		List<TaskInfo> allTasks = new ArrayList<>();
		for (EmployeeInfo employee : teamEmployees) {
			allTasks.addAll(employee.getTasks());
		}

		return allTasks; // Return the list of all tasks
	}
	
	public String deleteById(Integer id) {
		teamInfoRepository.deleteById(id);
		return "Team Deleted";
	}
}

