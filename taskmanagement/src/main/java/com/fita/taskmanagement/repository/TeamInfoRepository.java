package com.fita.taskmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fita.taskmanagement.bean.TeamInfo;

@Repository
public interface TeamInfoRepository extends JpaRepository<TeamInfo, Integer>{
	Optional<TeamInfo> findByTeamName(String teamName);
	Optional<TeamInfo> findAllByTeamName(String teamName);
}
