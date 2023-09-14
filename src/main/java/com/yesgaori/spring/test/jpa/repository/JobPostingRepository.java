package com.yesgaori.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.jpa.domain.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Integer>{

	// companyId 컬럼이 일치하는 행 조회
	// WHERE `companyId` = ??
	public List<JobPosting> findByCompanyId(int companyId);
	
	// position컬럼과 type컬럼이 모두 일치하는 행 조회
	// WHERE `position` = ?? AND `type` = ??
	public List<JobPosting> findByPositionAndType(String position, String type);
	
	// type 컬럼이 일치하거나 salary 컬럼의 값이 특정 값보다 이상인 행 조회
	// WHERE `type` = ?? OR `salary` >= ??
	public List<JobPosting> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// type 컬럼이 일치하는 행을 연봉기준으로 내림차순으로 3개 조회
	// WHERE `type` = ?? ORDER BY `salary` DESC LIMIT 3
	public List<JobPosting> findTop3ByTypeOrderBySalary(String type);
	
	// region 컬럼이 일치하고 salary 컬럼이 특정값 사이의 조건에 대응되는 행 조회
	// WHERE `region` = ?? AND `salary` BETWEEN ?? AND ??
	public List<JobPosting> findByRegionAndSalaryBetween(String region, int salaryStart, int salartEnd);
	
	//deadline 컬럼이 특정 값보다 크고 salary가 특정 값 보다 크고 type 이 일치하는 데이터를 연봉 내림차순으로 조회
	@Query(value="SELECT * FROM `jobposting`"
				+ "WHERE `deadline` > :deadline "
				+ "AND `salary` >= :type "
				+ "ORDER BY `salary` DESC", nativeQuery=true)
	public List<JobPosting> findByNativeQuery(@Param("deadline") String deadline
											, @Param("salary") int salary
											, @Param("type") String type);
}
