package com.fita.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fita.taskmanagement.bean.ProjectInfo;

@Repository
public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, Integer>{

}
