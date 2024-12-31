package com.fita.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fita.taskmanagement.bean.TeamLead;

@Repository
public interface TeamLeadRepository extends JpaRepository<TeamLead, Integer>{

}
