package com.flightbooking.TicketBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flightbooking.TicketBooking.util.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.TicketBooking.bean.Flights;
import com.flightbooking.TicketBooking.repository.FlightsRepository;

import javax.transaction.Transactional;

@Service
public class FlightsService {
	@Autowired
	public FlightsRepository flightRepo;

	public Map<String, Object> getAllFlights()
	{
		List<Flights> flights = new ArrayList<>();
		flightRepo.findAll().forEach(flights::add);
		return JsonResponseUtil.createJsonResponse("Data Fetched successfully", 200, flights);
	}

	public Map<String, Object> completeFlightDetails()
	{
		List<Map<String, Object>> obj = flightRepo.getCompleteFlightDetails();
		return JsonResponseUtil.createJsonResponse("Data Fetched successfully", 200, obj);
	}

	public Map<String, Object> searchFlightDetails(String sourceid, String desid, String date, String noofpass){
		List<Map<String, Object>> obj = flightRepo.searchFlightDetails(sourceid, desid, date, noofpass);
		return JsonResponseUtil.createJsonResponse("Data Fetched successfully", 200, obj);
	}

	public Map<String, Object> addFlight(Flights flights) {
		flightRepo.save(flights);
		return JsonResponseUtil.createJsonResponse("Data Inserted successfully", 200, "");
	}

	public Map<String, Object> updateFlight(String id, Flights flights) {
		flightRepo.save(flights);
		return JsonResponseUtil.createJsonResponse("Data Updated successfully", 200, "");
	}

	@Transactional
	public Map<String, Object> deleteFlight(Long id) {
		flightRepo.deleteById(id);
		return JsonResponseUtil.createJsonResponse("Data Deleted successfully", 200, "");
	}
}
