package com.fita.taskmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fita.taskmanagement.bean.EmployeeInfo;
import com.fita.taskmanagement.bean.TaskInfo;
import com.fita.taskmanagement.bean.TeamInfo;

@Repository
public interface TaskInfoRepository extends JpaRepository<TaskInfo, Integer>{
	
}
