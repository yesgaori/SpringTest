package com.yesgaori.spring.test.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.jstl.domain.WeatherHistory;
import com.yesgaori.spring.test.jstl.repository.WeatherHistoryRepository;

@Service
public class WeatherHistoryService {
	
	@Autowired
	WeatherHistoryRepository weatherHistoryRepository;
	
	public List<WeatherHistory> selectObjerct() {
		
		List<WeatherHistory> weatherHistory = weatherHistoryRepository.selectWeatherHistory();
		
		return weatherHistory;
	}
	
	
}
