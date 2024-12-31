package com.fita.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fita.taskmanagement.bean.Company;
import com.fita.taskmanagement.bean.CompanyDTO;
import com.fita.taskmanagement.service.CompanyService;

@RestController
@RequestMapping("/companyInfo")
public class CompanyController {
	@Autowired
    private CompanyService service;
    
    @PostMapping("/saveorupdate")
    public Company saveOrUpdate(@RequestBody CompanyDTO company) {
    	return service.saveOrUpdateCompany(company);
    }
}
