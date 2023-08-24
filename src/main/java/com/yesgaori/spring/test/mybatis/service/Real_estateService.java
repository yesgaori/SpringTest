package com.yesgaori.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.mybatis.domain.Real_estate;
import com.yesgaori.spring.test.mybatis.repository.Real_estateRepository;

@Service
public class Real_estateService {
	
	@Autowired
	private Real_estateRepository real_estateRepository;

	// 전달받은 id와 일치하는 매물정보를 돌려주는 기능
	
	
	public Real_estate getReal_estate(int id) {
		
		Real_estate real_estate = real_estateRepository.selectRepository(id);
		return real_estate;
	}
	// 전달받은 월세보다 낮은 매물정보 돌려주는 기능
	public List<Real_estate> getReal_estate2(int rentPrice) {
		
		List<Real_estate> real_estate = real_estateRepository.selectRepository2(rentPrice);
		return real_estate;
	}
	
}
