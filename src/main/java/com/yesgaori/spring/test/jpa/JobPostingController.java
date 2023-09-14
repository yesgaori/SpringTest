package com.yesgaori.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.test.jpa.domain.JobPosting;
import com.yesgaori.spring.test.jpa.repository.JobPostingRepository;

@RequestMapping("/jpa/jobposting")
@Controller
public class JobPostingController {
	
	@Autowired
	private JobPostingRepository jobPostingRepository;
	
	@GetMapping("/1")
	@ResponseBody
	public JobPosting jpaTest01() {
		
		Optional<JobPosting> optionalJobPosting = jobPostingRepository.findById(8);
		JobPosting jobPosting = optionalJobPosting.orElse(null);
		
		return jobPosting;
	}
	
	@GetMapping("/2")
	@ResponseBody
	public List<JobPosting> jpaTest02(@RequestParam("companyId") int companyId) {
		
		List<JobPosting> jobPostingList = jobPostingRepository.findByCompanyId(companyId);
		
		return jobPostingList;
	}
	
	@GetMapping("/3")
	@ResponseBody
	public List<JobPosting> jpaTest03() {
		
		List<JobPosting> jobPosting = jobPostingRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		return jobPosting;
		
	}
	
	@GetMapping("/4")
	@ResponseBody
	public List<JobPosting> jpaTest04() {
		
		List<JobPosting> jobPosting = jobPostingRepository.findByTypeOrSalaryGreaterThanEqual(null, 0);
		
		return jobPosting;
	}
	
	@GetMapping("/5")
	@ResponseBody
	public List<JobPosting> jpaTest05() {
		
		List<JobPosting> jobPosting = jobPostingRepository.findTop3ByTypeOrderBySalary("계약직");
		return jobPosting;
	}
	
	@GetMapping("/6")
	@ResponseBody
	public List<JobPosting> jpaTest06() {
		
		return jobPostingRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		
		
	}
	
	@GetMapping("/7")
	@ResponseBody
	public List<JobPosting> jpaTest07() {
		
		return jobPostingRepository.findByNativeQuery("2026-04-10 00:00:00", 8100, "정규직");
		
	}
}