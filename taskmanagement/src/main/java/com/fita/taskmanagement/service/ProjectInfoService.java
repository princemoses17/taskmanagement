package com.fita.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.taskmanagement.bean.EmployeeInfo;
import com.fita.taskmanagement.bean.ProjectInfo;
import com.fita.taskmanagement.bean.ProjectInfoDTO;
import com.fita.taskmanagement.bean.TaskInfo;
import com.fita.taskmanagement.repository.EmployeeRepository;
import com.fita.taskmanagement.repository.ProjectInfoRepository;
import com.fita.taskmanagement.repository.TaskInfoRepository;

@Service
public class ProjectInfoService {
	@Autowired
	private ProjectInfoRepository projectRepo;
	@Autowired
	private TaskInfoRepository taskRepo;
	@Autowired
	private EmployeeRepository empRepo;

	
	public ProjectInfo saveOrUpdateProject(ProjectInfoDTO projectInfoDTO) {
        ProjectInfo project;
        if (projectInfoDTO.getProjectId() != null) {
            project = projectRepo.findById(projectInfoDTO.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectInfoDTO.getProjectId()));
        } else {
            project = new ProjectInfo();
        }
        project.setProjectName(projectInfoDTO.getProjectName());
        if (projectInfoDTO.getTaskIds() != null && !projectInfoDTO.getTaskIds().isEmpty()) {
            List<TaskInfo> taskList = taskRepo.findAllById(projectInfoDTO.getTaskIds());
            project.setTaskList(taskList);
        }
        if (projectInfoDTO.getEmployeeIds() != null && !projectInfoDTO.getEmployeeIds().isEmpty()) {
            List<EmployeeInfo> teamMembers = empRepo.findAllById(projectInfoDTO.getEmployeeIds());
            project.setEmployeeList(teamMembers);
        }
        return projectRepo.save(project);
    }
	
	
	public ProjectInfo getById(Integer id) {
		return projectRepo.findById(id).get();
	}
	
	
	public List<ProjectInfo> getAll(){
		return projectRepo.findAll();
	}
	
	
	public String deleteById(Integer id) {
		projectRepo.deleteById(id);
		return "Project and it's tasks deleted";
	}
}
