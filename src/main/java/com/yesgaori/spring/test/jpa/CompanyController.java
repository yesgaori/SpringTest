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
			
		Company company = companyService.companyCreate("넥손", "컨텐츠 게임", "대기업", 3585);
		
		List<Company> companyList = new ArrayList<>();
		
		companyList.add(company);
		
		company = companyService.companyCreate("버블팡", "여신 금융업", "대기업", 6934);
		
		companyList.add(company);
		
		return companyList;
		
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany() {
	
		// id가 8인 회사정보의 규모를 중소기업, 사원수 34명으로 수정
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
		
	}
	
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany() {
		
		companyService.deleteCompany(8);
		
		return "수행완료";
		
	}
	
}
