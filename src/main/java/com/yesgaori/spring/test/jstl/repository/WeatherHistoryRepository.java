package com.yesgaori.spring.test.jstl.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.jstl.domain.WeatherHistory;

@Repository
public interface WeatherHistoryRepository {
	
	public List<WeatherHistory> selectWeatherHistory();
	
}
