package com.wofoo.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wofoo.app.entity.Booking;
import com.wofoo.app.entity.User;
import com.wofoo.app.repository.BookingRepository;

@Service
public class BookingService {
	
	private final BookingRepository bookingRepo;

	public BookingService(BookingRepository bookingRepo) {
		this.bookingRepo = bookingRepo;
	}
	
	public Booking saveBooking(Booking booking) {
		LocalDateTime start = booking.get_startTime();
		LocalDateTime end = booking.get_endTime();
		if(start == null || end == null || start.isAfter(end)) {
			throw new IllegalArgumentException("Invalid start time or end time");
		}
		return bookingRepo.save(booking);	
	}
	
	public List<Booking> findBooking(User user) {
		return bookingRepo.findByUser(user);
	}
	
	public List<Booking> findAllBookings() {
		return bookingRepo.findAll();
	}

}
