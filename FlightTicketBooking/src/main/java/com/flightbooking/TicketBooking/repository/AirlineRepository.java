package com.flightbooking.TicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.TicketBooking.bean.Airline;

public interface AirlineRepository extends JpaRepository<Airline, String>{
	

}
