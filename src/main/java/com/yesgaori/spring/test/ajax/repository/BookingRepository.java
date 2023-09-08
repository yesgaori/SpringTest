package com.yesgaori.spring.test.ajax.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.ajax.domain.Booking;

@Repository
public interface BookingRepository {
	
	public List<Booking> getBooking();
	
	public int deleteBooking(@Param("id") int id);
	
	
	public int insertBooking(
							@Param("name") String name
							, @Param("date") Date date
							, @Param("day") int day
							, @Param("headcount") int headcount
							, @Param("phoneNumber") String phoneNumber
							);
	
	
	public Booking selectBooking(
					@Param("name") String name
					,@Param("phoneNumber") String phonenNumber);
	
}
