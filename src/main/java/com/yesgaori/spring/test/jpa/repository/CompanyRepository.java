package com.yesgaori.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.jpa.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
