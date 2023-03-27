package com.wofoo.app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "booking")
public class Booking {
	
	@Id
	@SequenceGenerator(name = "booking_seq", sequenceName = "booking_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
	private int _id;
	
	@Column(name = "room", nullable = false)
	private String _roomNumber;
	
	@Column(nullable = false)
	private String _description;
	
	@Column(name = "time_created", nullable = false)
	@CreationTimestamp
	private LocalDateTime _createdAt;
	
	@Column(name = "start_time", nullable = false)
	private LocalDateTime _startTime;
	
	@Column(name = "end_time", nullable = false)
	private LocalDateTime _endTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User _user;

	@Override
	public String toString() {
		return "Booking [_id=" + _id + ", _roomNumber=" + _roomNumber + ", _description=" + _description
				+ ", _createdAt=" + _createdAt + ", _startTime=" + _startTime + ", _endTime=" + _endTime + ", _user="
				+ _user + "]";
	}
}
