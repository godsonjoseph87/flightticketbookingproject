package com.flightbooking.TicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.TicketBooking.bean.FlightBookings;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FlightBookingsRepository extends JpaRepository<FlightBookings, String>{

    @Query(value="select fb.name, fb.address, fb.email, fb.phone, m.name as source," +
            " mp.name as destination, f.price, f.time, air.airlinename" +
            " from flightbookings as fb " +
            " left join flights as f on f.id = fb.flightid" +
            " left join airlines as air on air.id = f.airlineid" +
            " left join masterplaces as m on m.id = f.sourceid" +
            " left join masterplaces as mp on mp.id = f.destinationid" +
            " where fb.id=?1", nativeQuery = true)
    public List<Map<String, Object>> findBookingDetails(String id);
}
