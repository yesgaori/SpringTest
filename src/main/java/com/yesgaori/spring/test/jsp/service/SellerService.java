package com.yesgaori.spring.test.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.jsp.domain.Seller;
import com.yesgaori.spring.test.jsp.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	SellerRepository sellerRepository; 
	
	public int addSeller(String nickname, String profileImage, double temperature){
		int count = sellerRepository.addSellerRepository(nickname, profileImage, temperature);
		
		return count;
	}
	
	public Seller findLastSeller() {
		
		Seller seller = sellerRepository.lastSeller();
		return seller;
		
	}
	
	public Seller getSeller(int id) {
		Seller seller = sellerRepository.selectSeller(id);
		
		return seller;
	}
}
