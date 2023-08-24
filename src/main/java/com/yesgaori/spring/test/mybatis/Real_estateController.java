package com.yesgaori.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.test.mybatis.domain.Real_estate;
import com.yesgaori.spring.test.mybatis.service.Real_estateService;

@RequestMapping("/mybatis/real_estate")
@Controller
public class Real_estateController {
	
	@Autowired
	private Real_estateService real_estateService;
	
	
	@RequestMapping("/1")
	@ResponseBody
	public Real_estate real_estate(@RequestParam("id")int id) {
		Real_estate real_estate = real_estateService.getReal_estate(id);
		return real_estate;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<Real_estate> real_estate2(@RequestParam("rentPrice")int rentPrice) {
		List<Real_estate> real_estate = real_estateService.getReal_estate2(rentPrice);
		return real_estate;
	}
	
}
