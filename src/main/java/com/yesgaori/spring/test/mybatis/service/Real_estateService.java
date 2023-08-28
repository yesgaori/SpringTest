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
	// 넓이와 가격 조건에 따른 매물정보 돌려주는 기능
	public List<Real_estate> getReal_estate3(int price, int area) {
		
		List<Real_estate> real_estate = real_estateRepository.selectRepository3(price, area);
		return real_estate;
	}
	
	//
	public int addRealestate1(Real_estate real_estate) {
		int count = real_estateRepository.insertRealestate(real_estate);
		return count;
	}
	
	
	// 전달받은 값으로 새로운 매물정보 등록하는 기능
	public int addRealestate2(int realtorId, String address, int area, String type, int price, int rentPrice) {
		int count = real_estateRepository.insertRealestateObject(realtorId, address, area, type, price, rentPrice);
		return count;
	}
	
	public int updateRealestate(int id, String type, int price) {
		
		int count = real_estateRepository.updateRealestate(id, type, price);
		return count;
	}
	
	public int deleteRealestate(int id) {
		
		int count = real_estateRepository.deleteRealestate(id);
		return count;
	}
	
}
