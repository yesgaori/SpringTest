package com.yesgaori.spring.test.jstl.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.jstl.domain.WeatherHistory;

@Repository
public interface WeatherHistoryRepository {
	
	public List<WeatherHistory> selectWeatherHistory();
	
	
	public int inputFuntion(@Param("date") String date
							, @Param("weather") String weather
							, @Param("temperatures") double temperatures
							, @Param("precipitation") double precipitation
							, @Param("microDust") String microDust
							, @Param("windSpeed") double windSpeed);
}
