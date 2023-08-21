package com.yesgaori.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01Controller {
	
	@RequestMapping("/1")
	public String title() {
		return "<h1>테스트 프로젝트 완성</h1><br><h3>해당 프로젝트를 통해 문제풀이를 진행 합니다.</h3>";
	}
	
	@RequestMapping("/2")
	public Map<String, Integer> mapResponse() {
		Map<String, Integer> scoreMap = new HashMap<>();
		
		scoreMap.put("국어", 80);
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 85);
		
		return scoreMap;
	}
	
}
