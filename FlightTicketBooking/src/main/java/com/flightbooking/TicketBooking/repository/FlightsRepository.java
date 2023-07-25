package com.flightbooking.TicketBooking.repository;

import com.flightbooking.TicketBooking.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.TicketBooking.bean.Flights;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface FlightsRepository extends JpaRepository<Flights, String>{

    @Query(value="select f.id, f.name, f.price, f.time, air.airlinename as airline, mp.name as destination," +
            " mpp.name as source from flights as f" +
            " left join airlines as air on air.id = f.airlineid" +
            " left join masterplaces as mp on mp.id = f.destinationid" +
            " left join masterplaces as mpp on mpp.id = f.sourceid", nativeQuery = true)
    public List<Map<String, Object>> getCompleteFlightDetails();

    @Query(value="select f.id, f.name, f.price, f.time, air.airlinename as airline, mp.name as destination," +
            " mpp.name as source, f.capacity from flights as f" +
            " left join airlines as air on air.id = f.airlineid" +
            " left join masterplaces as mp on mp.id = f.destinationid" +
            " left join masterplaces as mpp on mpp.id = f.sourceid" +
            " where f.sourceid=?1 and f.destinationid=?2 and f.time=?3 and f.capacity>=?4", nativeQuery = true)
    public List<Map<String, Object>> searchFlightDetails(String sourceid, String desid, String date, String noofpass);

    public void deleteById(Long id);
}
