package com.wofoo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wofoo.app.entity.Booking;
import com.wofoo.app.entity.User;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	List<Booking> findByUser(User user);

}
