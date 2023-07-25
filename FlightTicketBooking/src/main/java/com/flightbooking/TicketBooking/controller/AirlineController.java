package com.flightbooking.TicketBooking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.TicketBooking.bean.Airline;
import com.flightbooking.TicketBooking.service.AirlineService;

@RestController
public class AirlineController {
	@Autowired
	private AirlineService airlineService;

	@RequestMapping("/airlines")
	public Map<String, Object> getAllAirliness()
	{
		return airlineService.getAllAirlines();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/airlines")
	public Map<String, Object> addClasses(@RequestBody Airline airline)
	{
		return airlineService.addAirline(airline);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/airline/{id}")
	public Map<String, Object> updateAirline(@PathVariable String id, @RequestBody Airline airline)
	{
		return airlineService.updateAirline(id, airline);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/airline/{id}")
	public Map<String, Object> DeleteAirline(@PathVariable String id)
	{
		return airlineService.deleteAirline(id);
	}
}
