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

import com.fita.taskmanagement.bean.EmployeeInfo;
import com.fita.taskmanagement.bean.TaskInfo;
import com.fita.taskmanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/saveorupdate")
	public EmployeeInfo saveOrUpdateEmployee(@RequestBody EmployeeInfo emp) {
		return service.saveOrUpdateEmployee(emp);
	}
	
	@GetMapping("/byId/{prince}")
	public EmployeeInfo getById(@PathVariable("prince") Integer id) {
		return service.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<EmployeeInfo> getAll(){
		return service.getAll();
	}
	
	@DeleteMapping("/delete/{prince}")
	public String deleteById(@PathVariable("prince") Integer id) {
		return service.deleteById(id);
	}
	
	@GetMapping("/getTasks/{prince}")
	public List<TaskInfo> getTasksByEmployeeId(@PathVariable("prince") Integer id){
		return service.getTasksByEmployeeId(id);
	}
}
