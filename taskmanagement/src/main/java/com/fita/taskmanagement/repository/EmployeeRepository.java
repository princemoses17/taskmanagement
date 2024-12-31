package com.fita.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fita.taskmanagement.bean.EmployeeInfo;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Integer>{

}
