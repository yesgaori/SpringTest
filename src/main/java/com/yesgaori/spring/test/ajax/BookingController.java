package com.yesgaori.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yesgaori.spring.test.ajax.domain.Booking;
import com.yesgaori.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/bigwood")
@Controller
public class BookingController {
	
	@Autowired
	public BookingService bookingService;
	
	
	
	@GetMapping("/home")
	public String home() {
		
		return "ajax/totalTest/home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
			
		List<Booking> reservation = bookingService.getBooking();
		
		model.addAttribute("reservation", reservation);
		
		
		return "ajax/totalTest/reservationList";
	}
	
	
}
