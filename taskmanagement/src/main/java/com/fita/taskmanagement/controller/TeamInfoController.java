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

import com.fita.taskmanagement.bean.TaskInfo;
import com.fita.taskmanagement.bean.TeamInfo;
import com.fita.taskmanagement.bean.TeamInfoDTO;
import com.fita.taskmanagement.service.TeamInfoService;
@RestController
@RequestMapping("/teamInfo")
public class TeamInfoController {
	
	@Autowired	
	private TeamInfoService service;
	
	@PostMapping("/saveorupdate")
	public TeamInfo saveOrUpdate(@RequestBody TeamInfoDTO team) {
		return service.saveOrUpdateTeamInfo(team);
	}
	@GetMapping("/byTeamName/{prince}")
	public TeamInfo getByTeamName(@PathVariable("prince") String teamName) {
         return service.getByTeamName(teamName);
}
	
	@GetMapping("/getTasks/{prince}")
	public List<TaskInfo> getTasksByTeamName(@PathVariable("prince") String teamName){
		return service.getTasksForAllEmployeesByTeamName(teamName);
	}
	@DeleteMapping("/delete/{prince}")
	public String deleteById(@PathVariable("prince") Integer id) {
		return service.deleteById(id);
	}
}
