package com.yesgaori.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.jsp.domain.Realtor;
import com.yesgaori.spring.test.jsp.repository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		int count = realtorRepository.addRealtorRepository(realtor);
		return count;
	}
	
	public Realtor realtorinfoService() {
		Realtor realtor = realtorRepository.selectRealtor();
		
		return realtor;
	}
	
}
