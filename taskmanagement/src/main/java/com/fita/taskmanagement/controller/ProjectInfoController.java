package com.fita.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fita.taskmanagement.bean.ProjectInfo;
import com.fita.taskmanagement.bean.ProjectInfoDTO;
import com.fita.taskmanagement.service.ProjectInfoService;

@RestController
@RequestMapping("/projectInfo")
public class ProjectInfoController {
	@Autowired
	private ProjectInfoService service;
	
	@PostMapping("/saveorupdate")
	public ProjectInfo saveOrUpdate(@RequestBody ProjectInfoDTO project) {
		return service.saveOrUpdateProject(project);
	}
    
	@GetMapping("/byId/{prince}")
	public ProjectInfo getById(@PathVariable("prince") Integer id) {
		return service.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<ProjectInfo>getAll(){
		return service.getAll();
	}
	
	@DeleteMapping("/delete/{prince}")
	public String deleteById(@PathVariable("prince") Integer id) {
		return service.deleteById(id);
	}
}
