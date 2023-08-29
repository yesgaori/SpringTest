package com.yesgaori.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.test.jsp.service.RealtorService;
@RequestMapping("/jsp/realtor")
@Controller
public class RealtorController {
	
	@Autowired
	RealtorService realtorService;
	
	
	@PostMapping("/insert")
	@ResponseBody
	public String addRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade) {
		
		int count = realtorService.addRealtor(office, phoneNumber, address, grade);
		
		return "수행결과 : " + count;
		
	}
	
	@GetMapping("/add")
	public String addPage() {
		
		
		return "jsp/addRealtor";
	}
	
	
}
