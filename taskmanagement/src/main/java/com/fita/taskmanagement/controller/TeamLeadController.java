package com.fita.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fita.taskmanagement.bean.TeamLead;
import com.fita.taskmanagement.bean.TeamLeadDTO;
import com.fita.taskmanagement.service.TeamLeadService;

@RestController
@RequestMapping("/teamLead")
public class TeamLeadController {
	
      @Autowired
      private TeamLeadService service;
      
      @PostMapping("/saveorupdate")
      public TeamLead saveOrUpdate(@RequestBody TeamLeadDTO request) {
    	  return service.saveOrUpdateTeamLead(request);
      }
      @DeleteMapping("/delete/{prince}")
      public String deleteById(@PathVariable("prince") Integer id) {
    	  return service.deleteById(id);
      }
}
