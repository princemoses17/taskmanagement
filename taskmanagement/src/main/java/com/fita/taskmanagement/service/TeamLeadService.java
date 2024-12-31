package com.fita.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.taskmanagement.bean.EmployeeInfo;
import com.fita.taskmanagement.bean.ProjectInfo;
import com.fita.taskmanagement.bean.TeamLead;
import com.fita.taskmanagement.bean.TeamLeadDTO;
import com.fita.taskmanagement.repository.EmployeeRepository;
import com.fita.taskmanagement.repository.ProjectInfoRepository;
import com.fita.taskmanagement.repository.TeamLeadRepository;

@Service
public class TeamLeadService {
	  @Autowired
      private TeamLeadRepository leadRepo;
	  @Autowired
	  private ProjectInfoRepository projectRepo;
	  @Autowired
	  private EmployeeRepository empRepo;
	  
	  
	  public TeamLead saveOrUpdateTeamLead(TeamLeadDTO teamLeadRequest) {
	       
	        EmployeeInfo teamLeadEmployee = empRepo.findById(teamLeadRequest.getEmployeeId())
	                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + teamLeadRequest.getEmployeeId()));

	        List<EmployeeInfo> teamMembers = empRepo.findAllById(teamLeadRequest.getTeamMembers());

	        List<ProjectInfo> projectList = projectRepo.findAllById(teamLeadRequest.getProjectIds());

	        TeamLead teamLead;
	        if (teamLeadRequest.getTeamLeadId() != null) {
	            teamLead = leadRepo.findById(teamLeadRequest.getTeamLeadId())
	                    .orElseThrow(() -> new RuntimeException("TeamLead not found with ID: " + teamLeadRequest.getTeamLeadId()));
	        } else {
	            teamLead = new TeamLead();
	        }

	        teamLead.setEmployee(teamLeadEmployee);
	        teamLead.setTeamMembers(teamMembers);
	        teamLead.setProjectList(projectList);

	        return leadRepo.save(teamLead);
	    }
	  public String deleteById(Integer id) {
		  leadRepo.deleteById(id);
		  return "Deleted successfully";
	  }
	}

