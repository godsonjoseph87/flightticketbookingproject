package com.flightbooking.TicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.TicketBooking.bean.Payments;

public interface PaymentRepository extends JpaRepository<Payments, String>{


}
