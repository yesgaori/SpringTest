package com.yesgaori.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yesgaori.spring.test.jsp.domain.Seller;
import com.yesgaori.spring.test.jsp.service.SellerService;
@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@GetMapping("/input")
	public String addSeller(
							@RequestParam("nickname") String nickName
							, @RequestParam("profileImage") String profileImage
							, @RequestParam("temperature") double temperature){
		
		int count = sellerService.addSeller(nickName, profileImage, temperature);
		
		return "수행결과 : " + count;
		
	}
	@GetMapping("/last")
	public  String getLast(Model model) {
		
		Seller seller = sellerService.findLastSeller();
		
		model.addAttribute("result", seller);
		
		
		return "jsp/sellerInfo";
	}
	
}
