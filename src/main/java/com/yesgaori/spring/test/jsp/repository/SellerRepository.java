package com.yesgaori.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.jsp.domain.Seller;

@Repository
public interface SellerRepository {
	
	public int addSellerRepository(
									@Param("nickname") String nickName
									, @Param("profileImage")String profileImage
									, @Param("temperature")double temperature);
	
	public Seller lastSeller();
	
}
