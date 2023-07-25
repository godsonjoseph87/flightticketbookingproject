package com.flightbooking.TicketBooking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.TicketBooking.bean.Flights;
import com.flightbooking.TicketBooking.service.FlightsService;

@RestController
public class FlightsController {
	@Autowired
	private FlightsService flightsService;

	@RequestMapping("/flights")
	public Map<String, Object> getAllClasses()
	{
		return flightsService.getAllFlights();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/flights")
	public Map<String, Object> addClasses(@RequestBody Flights flights)
	{
		return flightsService.addFlight(flights);
	}

	@RequestMapping(method = RequestMethod.GET, value="/completeflightdetails")
	public Map<String, Object> completeFlightDetails()
	{
		return flightsService.completeFlightDetails();
	}

	@RequestMapping(method = RequestMethod.GET, value="/searchflights/{sourceid}/{desid}/{date}/{noofpass}")
	public Map<String, Object> searchFlightDetails(@PathVariable String sourceid, @PathVariable String desid, @PathVariable String date, @PathVariable String noofpass)
	{
		return flightsService.searchFlightDetails(sourceid, desid, date, noofpass);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/flight/{id}")
	public Map<String, Object> updateFlight(@PathVariable String id, @RequestBody Flights classes)
	{
		return flightsService.updateFlight(id, classes);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/flight/{id}")
	public Map<String, Object> DeleteFlight(@PathVariable Long id)
	{
		return flightsService.deleteFlight(id);
	}
}
