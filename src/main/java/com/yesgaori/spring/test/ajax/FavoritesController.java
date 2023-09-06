package com.yesgaori.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.test.ajax.domain.Favorites;
import com.yesgaori.spring.test.ajax.service.FavoritesService;

@RequestMapping("/ajax/favorites")
@Controller
public class FavoritesController {

	@Autowired
	public FavoritesService favoritesService;
	
	
	@GetMapping("/input")
	public String inputSite() {
		
		return "ajax/favoritesAdd";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Favorites> favoritesList = favoritesService.loadList();
		
		model.addAttribute("favoritesList", favoritesList);
		
		return "ajax/favoritesList";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createFavorites(
						  @RequestParam("name") String name
						  , @RequestParam("url") String url
						  , Model model) {
		
		int count = favoritesService.addFavorites(name, url);
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap=new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	@PostMapping("/duplicate-url")
	@ResponseBody
	public Map<String, Boolean>isDuplicateEmail(@RequestParam("url") String url) {
		
		boolean duplicate = favoritesService.isDuplicateEmailService(url);
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(duplicate) {
			result.put("isDuplicate", true);
		} else {
			result.put("isDuplicate", false);
		}
		
		return result;
	}
	
}
