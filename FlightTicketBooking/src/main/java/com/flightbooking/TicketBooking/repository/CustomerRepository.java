package com.flightbooking.TicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.TicketBooking.bean.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	

}
