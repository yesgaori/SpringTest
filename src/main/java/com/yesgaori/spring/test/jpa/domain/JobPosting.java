package com.yesgaori.spring.test.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
@Getter
@Table(name="jobposting")
@Entity
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="companyId")
	private int companyId;
	
	private String position;
	private String respinsibilities;
	private String qualification;
	private String type;
	private String region;
	private int salary;
	private String deadline;
	
	@UpdateTimestamp
	@Column(name="createAt", updatable=false) 
	private Date createdAt;
	@Column(name="updatedAt")
	private Date updatedAt;
	
	
}
