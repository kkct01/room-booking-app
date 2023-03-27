package com.wofoo.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
	@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private int _id;
	
	@Column(name = "staff_name", nullable = false, unique = true, length = 50)
	private String _name;
	
	@Column(name = "password", nullable = false)
	private String _password;
	
	@Column(name = "role", nullable = false)
	private String _role = "USER";
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings;

	@Override
	public String toString() {
		return "User [id=" + _id + ", name=" + _name + ", password=" + _password + ", role=" + _role + ", bookings="
				+ bookings + "]";
	}
}
