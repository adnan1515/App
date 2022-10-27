package io.javaprojects.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.javaprojects.model.Bookings;
import io.javaprojects.service.UserService;
import io.javaprojects.service.UserServiceImpl;
import io.javaprojects.web.dto.BookingDto;
import io.javaprojects.web.dto.UserLoginDto;
import io.javaprojects.web.dto.UserRegistrationDTO;

@Controller

public class UserRegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	UserServiceImpl service;
	Long id = null;

	@RequestMapping("/register")
	public ResponseEntity<String> registerUserAccount(@RequestBody UserRegistrationDTO dto) {
		userService.save(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Registeration success", "foo");

		return new ResponseEntity<>("Registration Success", headers, HttpStatus.OK);
	}

	@RequestMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserLoginDto dto) {

		boolean success = service.login(dto);
		if (success) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("login success", "foo");
			this.id = service.getUserId(dto);
			return new ResponseEntity<>("login Success", headers, HttpStatus.OK);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.add("login failure", "foo");
			return new ResponseEntity<>("login failure", headers, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping("/book")
	public ResponseEntity<String> book(@RequestBody BookingDto bookingDto) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Booking failure", "foo");
		if (id == null) {
			return new ResponseEntity<>("Booking Failure", headers, HttpStatus.NOT_FOUND);
		}
		service.addBookings(bookingDto);
		headers = new HttpHeaders();
		headers.add("Booking success", "foo");

		return new ResponseEntity<>("Booking Success", headers, HttpStatus.OK);
	}

	@RequestMapping("/allBookings")
	public ResponseEntity<List<Bookings>> getAllBookings() {

		List<Bookings> list = service.getAllBookings(this.id);
		if (list.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(list);

	}

	@RequestMapping("/addStation")
	public void addStation(BookingDto bd) {
		service.addStation(bd);
	}

}
