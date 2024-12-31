package com.fita.taskmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.taskmanagement.bean.Company;
import com.fita.taskmanagement.bean.CompanyDTO;
import com.fita.taskmanagement.bean.TeamInfo;
import com.fita.taskmanagement.bean.TeamInfoDTO;
import com.fita.taskmanagement.repository.CompanyRepository;
import com.fita.taskmanagement.repository.TeamInfoRepository;

@Service
public class CompanyService {
	 @Autowired
	    private CompanyRepository companyRepository;

	    @Autowired
	    private TeamInfoRepository teamInfoRepository;

	    public Company saveOrUpdateCompany(CompanyDTO companyRequest) {
	        // Create or update the company object
	        Company company;
	        if (companyRequest.getCompanyId() != null) {
	            // If companyId is provided, fetch the existing company for update
	            company = companyRepository.findById(companyRequest.getCompanyId())
	                    .orElseThrow(() -> new RuntimeException("Company not found with ID: " + companyRequest.getCompanyId()));
	        } else {
	            // If companyId is not provided, create a new company
	            company = new Company();
	        }

	        // Set the company details
	        company.setCompanyName(companyRequest.getCompanyName());
	        company.setAdrress(companyRequest.getAddress());
	        company.setPincode(companyRequest.getPincode());

	        // Fetch and set the teamList based on teamIds provided in the request
	        List<TeamInfo> teamList = teamInfoRepository.findAllById(companyRequest.getTeamIds());
	        company.setTeamList(teamList);

	        // Save or update the company
	        return companyRepository.save(company);
	    }
	}


