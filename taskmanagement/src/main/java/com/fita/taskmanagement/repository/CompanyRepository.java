package com.fita.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fita.taskmanagement.bean.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
