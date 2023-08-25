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
	
	
	@RequestMapping("/select/1")
	@ResponseBody
	public Real_estate real_estate(@RequestParam("id")int id) {
		Real_estate real_estate = real_estateService.getReal_estate(id);
		return real_estate;
	}
	
	@RequestMapping("/select/2")
	@ResponseBody
	public List<Real_estate> real_estate2(@RequestParam("rentPrice")int rentPrice) {
		List<Real_estate> real_estate = real_estateService.getReal_estate2(rentPrice);
		return real_estate;
	}
	
	@RequestMapping("/select/3")
	@ResponseBody
	public List<Real_estate> real_estate3(@RequestParam("price")int price, @RequestParam("area") int area) {
		List<Real_estate> real_estate = real_estateService.getReal_estate3(price, area);
		return real_estate;
	}
	
	@RequestMapping("/insert/1")
	@ResponseBody
	public String create() {
		
		Real_estate real_estate = new Real_estate();
		real_estate.setRealtorId(3);
		real_estate.setAddress("푸르지용 리버 303동 1104호");
		real_estate.setArea(89);
		real_estate.setType("매매");
		real_estate.setPrice(100000);
		
		int count = real_estateService.addRealestate1(real_estate);
		return "수행결과 : " + count;
	}
	
	@RequestMapping("/insert/2")
	@ResponseBody
	public String createObject(@RequestParam("realtorId") int realtorId) {
		
		int count = real_estateService.addRealestate2(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "수행결과 : " + count;
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateObject() {
		Real_estate realestate = new Real_estate();
		realestate.setType("전세");
		realestate.setPrice(70000);
		
		int count = real_estateService.updateRealestate(realestate);
		return "수정 성공 : " + count;
	}
}
