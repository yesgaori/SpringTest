package com.yesgaori.spring.test.jstl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yesgaori.spring.test.jstl.domain.WeatherHistory;
import com.yesgaori.spring.test.jstl.service.WeatherHistoryService;

@Controller
public class WeatherHistoryController {
	
	
	
	
	@Autowired
	WeatherHistoryService weatherHistoryService; 
	
	@GetMapping("/jstl/totaltest01")
	public String totalTest(Model model) {
		
		List<WeatherHistory> weatherHistory = weatherHistoryService.selectObjerct();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "jstl/totalTest01";
	}
	
	@GetMapping("/jstl/totaltest01-2")
	public String totalTest2() {
		
		return "jstl/totalTest01-2";
	}
	
	@GetMapping("/jstl/totaltest01/input")
	public String totalTestInput(@RequestParam("date") String date// 타입이 Date 일때 @DateTimeFormat(parrtern="yyyy년MM월dd일") 이라고 넣으면 됨
								, @RequestParam("weather") String weather
								, @RequestParam("temperatures") double temperatures
								, @RequestParam("precipitation") double precipitation
								, @RequestParam("microDust") String microDust
								, @RequestParam("windSpeed") double windSpeed
								, Model model) {
	
		int count = weatherHistoryService.inputWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);

		
		return "redirect:/jstl/totaltest01";
		
		
	}
}
