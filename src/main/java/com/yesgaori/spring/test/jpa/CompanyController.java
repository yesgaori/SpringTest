package com.yesgaori.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.test.jpa.domain.Company;
import com.yesgaori.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	
	@GetMapping("/create")
	@ResponseBody
	public List<Company> createCompany() {
		
		String name = "넥손"; 
		String business = "컨텐츠 게임"; 
		String scale = "대기업"; 
		int headcount = 3585;
		
		Company company = companyService.companyCreate(name, business, scale, headcount);
		
		List<Company> companyList = new ArrayList<>();
		
		companyList.add(company);
		
		name = "버블팡";
		
		
		
	}
	
	
}
