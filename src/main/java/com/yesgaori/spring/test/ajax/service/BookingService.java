package com.yesgaori.spring.test.ajax.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.ajax.domain.Booking;
import com.yesgaori.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getBooking() {
		
		List<Booking> list = bookingRepository.getBooking();
		
		return list;
	}
	
	public int deleteBooking(int id) {
		
		int count = bookingRepository.deleteBooking(id); 
		
		return count;
	}
	
	public int insertBooking(String name
							, Date date
							, int  day
							, int headcount
							, String phoneNumber) {
		
		
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber);
		
		return count;
	}
	
	public Booking getBooking(String name, String PhoneNumber) {
		
		Booking booking = bookingRepository.selectBooking(name, PhoneNumber);
		
		return booking;
		
	}
	
	
}
