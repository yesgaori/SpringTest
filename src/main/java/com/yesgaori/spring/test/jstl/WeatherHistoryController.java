package com.yesgaori.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
