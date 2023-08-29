package com.yesgaori.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.jsp.repository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	RealtorRepository realtorRepository;
	
	public int addRealtor(String office, String phoneNumber, String address, String grade) {
		int count = realtorRepository.addRealtorRepository(office, phoneNumber, address, grade);
		return count;
	}
	
}
