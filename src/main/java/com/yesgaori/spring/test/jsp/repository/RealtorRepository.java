package com.yesgaori.spring.test.jsp.repository;

import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.jsp.domain.Realtor;

@Repository
public interface RealtorRepository {
	
	public int addRealtorRepository(Realtor realtor);
	
	public Realtor selectRealtor();
	
	
	
}
