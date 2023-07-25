package com.flightbooking.TicketBooking.service;

import java.util.*;

import com.flightbooking.TicketBooking.util.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.TicketBooking.bean.FlightBookings;
import com.flightbooking.TicketBooking.repository.FlightBookingsRepository;

@Service
public class FlightBookingsService {
    @Autowired
    public FlightBookingsRepository flightbookingRepo;


    public Map<String, Object> getBookingDetails(String id) {
        System.out.println(id);
        List<Map<String, Object>> flightbookins = flightbookingRepo.findBookingDetails(id);
        System.out.println(flightbookins);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, flightbookins);
    }

    public Map<String, Object> addFlightBookings(FlightBookings flightbookings) {
        FlightBookings savedBooking = flightbookingRepo.save(flightbookings);
        Long id = savedBooking.getId();
        Map<String, Object> jsonResponse = new HashMap<>();
        List<Map<String, Object>> responseList = new ArrayList<>();
        jsonResponse.put("bookingid", id);
        responseList.add(jsonResponse);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, responseList);
    }
}
