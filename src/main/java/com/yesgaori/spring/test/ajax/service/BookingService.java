package com.yesgaori.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.ajax.domain.Booking;
import com.yesgaori.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	public BookingRepository bookingRepository;
	
	public List<Booking> getBooking() {
		
		List<Booking> list = bookingRepository.getBooking();
		
		return list;
	}
	
	
}
