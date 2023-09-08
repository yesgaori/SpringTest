package com.yesgaori.spring.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.test.ajax.domain.Booking;
import com.yesgaori.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	
	
	@GetMapping("/home")
	public String home() {
		
		return "ajax/totalTest/home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
			
		List<Booking> reservationList = bookingService.getBooking();
		
		model.addAttribute("reservationList", reservationList);
		
		
		return "ajax/totalTest/reservationList";
	}
	
	
	@PostMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteMap(@RequestParam("id") int id) {
		
		int count = bookingService.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@GetMapping("/add")
	public String inputPage() {
		
		return "ajax/totalTest/reservationInput";
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createBooking(
						@RequestParam("name") String name
						,@DateTimeFormat(pattern="yyyy년MM월dd일") @RequestParam("date") Date date
						,@RequestParam("day") int day
						,@RequestParam("headcount") int headcount
						,@RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingService.insertBooking(name, date, day, headcount, phoneNumber);
		
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) { 
			resultMap.put("result", "success");
			
		} else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
		
		
	}
	
	// 이름과 전화번호를 전달 받고,
	// 일치하는 예약 정보를 response에 json으로 담아주는 API
	@GetMapping("/search")
	@ResponseBody
	public Booking searchBooking(
			@RequestParam("name")String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingService.getBooking(name, phoneNumber);
		
		// 응답 json에 조회된 데이터가 있는지 없는지 정보를 명확하게 정의 한다.
		
		// {"name":김인규, "date":"2023-01-12", "day":2......}
		
		
		return booking;
		
		
	}
	
}
