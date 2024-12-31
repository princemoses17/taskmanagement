package com.fita.taskmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.taskmanagement.bean.EmployeeInfo;
import com.fita.taskmanagement.bean.TaskInfo;
import com.fita.taskmanagement.repository.EmployeeRepository;
import com.fita.taskmanagement.repository.TaskInfoRepository;

@Service
public class EmployeeService {
	
   @Autowired
   private EmployeeRepository empRepo;
   @Autowired
   private TaskInfoRepository taskInfoRepository;
   
   public EmployeeInfo saveOrUpdateEmployee(EmployeeInfo employeeInfo) {
	    // Step 1: Extract task IDs
	    List<Integer> taskIds = employeeInfo.getTasks().stream()
	            .map(TaskInfo::getTaskId)
	            .collect(Collectors.toList());

	    // Step 2: Fetch TaskInfo entities from the database
	    List<TaskInfo> tasks = taskInfoRepository.findAllById(taskIds);

	    // Step 3: Validate the task IDs
	    if (tasks.size() != taskIds.size()) {
	        throw new IllegalArgumentException("One or more Task IDs are invalid.");
	    }

	    // Step 4: Replace the tasks in EmployeeInfo
	    employeeInfo.setTasks(tasks);

	    // Step 5: Save or update EmployeeInfo
	    return empRepo.save(employeeInfo);
	}
   
   public EmployeeInfo getById(Integer empId) {
	   return empRepo.findById(empId).get();
   }
   
   public List<EmployeeInfo> getAll(){
	   return empRepo.findAll();
   }
   
   public String deleteById(Integer id) {
	   empRepo.deleteById(id);
	   return "Deleted successfully";
   }
   
   public List<TaskInfo> getTasksByEmployeeId(Integer id){
	   EmployeeInfo employee=empRepo.findById(id).get();
	   return employee.getTasks();
   }
}
