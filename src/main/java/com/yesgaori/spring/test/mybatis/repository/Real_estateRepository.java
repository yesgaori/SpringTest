package com.yesgaori.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.mybatis.domain.Real_estate;

@Repository
public interface Real_estateRepository {
	
	// 전달받은 id와 일치하는 한행의 매물정보를 돌려주는 기능
	public Real_estate selectRepository(@Param("id") int id);
	
	
	// 전달받은 월세보다 낮은 매물 정보 행들을 돌려주는 기능
	public List<Real_estate> selectRepository2(@Param("rentPrice") int rentPrice);
	
}
