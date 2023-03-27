package com.wofoo.app.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wofoo.app.entity.Booking;
import com.wofoo.app.entity.User;
import com.wofoo.app.service.BookingService;
import com.wofoo.app.service.UserService;

@RestController
@RequestMapping("/wofoo/booking")
public class BookingController {

	private final BookingService bookingService;
	private final UserService userService;

	public BookingController(BookingService bookingService, UserService userService) {
		this.bookingService = bookingService;
		this.userService = userService;
	}

	@PostMapping("/save")
	public ResponseEntity<Object> saveBooking(@RequestBody Booking booking) {
		try {
			User user = userService.findUserByName(booking.get_user().get_name());
			booking.set_user(user);
			Booking savedBooking = bookingService.saveBooking(booking);
			return ResponseEntity.ok(savedBooking);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Booking data violates constraints");
		} catch (TransactionSystemException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to save booking due to transaction error");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An unexpected error occured" + e.getMessage());
		}
	}

	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> findAllBookings() {
		List<Booking> bookings = bookingService.findAllBookings();
		return ResponseEntity.ok(bookings);
	}
}
