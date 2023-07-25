package com.flightbooking.TicketBooking.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.flightbooking.TicketBooking.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.TicketBooking.bean.FlightBookings;
import com.flightbooking.TicketBooking.service.FlightBookingsService;

@RestController
public class FlightBookingsController {
    @Autowired
    private FlightBookingsService flightbookingService;

    @RequestMapping(method = RequestMethod.GET, value="/flightbooking/{id}")
    public Map<String, Object> getBookingDetails(@PathVariable String id)
    {
        return flightbookingService.getBookingDetails(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/flightbooking")
    public Map<String, Object> addFlightBookings(@RequestBody FlightBookings fligntbooking)
    {
        return flightbookingService.addFlightBookings(fligntbooking);
    }

}
