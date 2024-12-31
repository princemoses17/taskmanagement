package com.fita.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.taskmanagement.bean.EmployeeInfo;
import com.fita.taskmanagement.bean.TaskInfo;
import com.fita.taskmanagement.bean.TeamInfo;
import com.fita.taskmanagement.repository.EmployeeRepository;
import com.fita.taskmanagement.repository.TaskInfoRepository;
import com.fita.taskmanagement.repository.TeamInfoRepository;

@Service
public class TaskInfoService {
	@Autowired
	private TaskInfoRepository taskRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private TeamInfoRepository teamInfoRepo;
	
	public TaskInfo saveOrUpdateTaskInfo(TaskInfo task) {
		if (task.getTaskId() != null) {
            TaskInfo existingTask = taskRepo.findById(task.getTaskId())
                    .orElseThrow(() -> new RuntimeException("Task not found with ID: " + task.getTaskId()));

            existingTask.setTaskTitle(task.getTaskTitle());
            existingTask.setTaskDescription(task.getTaskDescription());
            existingTask.setStatus(task.getStatus());

            return taskRepo.save(existingTask);
        } else {
		return taskRepo.save(task);
	}
}
	public String deleteById(Integer id) {
		taskRepo.deleteById(id);
		return "Task Deleted";
	}
	
	public TaskInfo getById(Integer id) {
		return taskRepo.findById(id).get();
		
	}
	public List<TaskInfo> getAll(){
       return taskRepo.findAll();
	}
}




























