package com.yesgaori.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yesgaori.spring.test.jsp.domain.Realtor;
import com.yesgaori.spring.test.jsp.service.RealtorService;
@RequestMapping("/jsp/realtor")
@Controller
public class RealtorController {
	
	@Autowired
	RealtorService realtorService;
	
	
	@PostMapping("/insert")
	public String addRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model) {
		
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtor(realtor);
		realtor = realtorService.realtorinfoService();
		
		model.addAttribute("realtor", realtor);
		
		return "jsp/realtorInfo";
		
	}
	
	@GetMapping("/add")
	public String addPage() {
		
		
		return "jsp/addRealtor";
	}
	
	
	
	
}
