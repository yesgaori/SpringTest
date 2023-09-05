package com.yesgaori.spring.test.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ajax/favorites")
@Controller
public class FavoritesController {
	
	@GetMapping("/input")
	public String inputSite() {
		
		return "ajax/favoritesAdd";
	}
	
	@GetMapping("/list")
	public String list() {
		
	}
	
	
	
}
