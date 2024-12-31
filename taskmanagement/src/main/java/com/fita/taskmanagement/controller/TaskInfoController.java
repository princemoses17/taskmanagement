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
import com.fita.taskmanagement.bean.TeamInfo;
import com.fita.taskmanagement.repository.EmployeeRepository;
import com.fita.taskmanagement.repository.TaskInfoRepository;
import com.fita.taskmanagement.service.TaskInfoService;

@RestController
@RequestMapping("/taskInfo")
public class TaskInfoController {
    @Autowired
	private TaskInfoService service;
    @Autowired
    private EmployeeRepository empRepo;
    @Autowired
    private TaskInfoRepository taskRepo;
    
    @PostMapping("/saveorupdate")
    public TaskInfo save(@RequestBody TaskInfo task) {
    	return service.saveOrUpdateTaskInfo(task);
    }
    
    @DeleteMapping("delete/{prince}")
    public String deleteById(@PathVariable("prince") Integer id) {
		return service.deleteById(id);
	}
    
    @GetMapping("/byId/{prince}")
    public TaskInfo getById(@PathVariable("prince") Integer id) {
        return service.getById(id);
    }
    
    @GetMapping("/getAll")
    public List<TaskInfo> getAll(){
    	return service.getAll();
    }
    
}
