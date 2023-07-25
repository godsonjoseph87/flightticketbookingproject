package com.flightbooking.TicketBooking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.TicketBooking.bean.MasterPlaces;
import com.flightbooking.TicketBooking.service.MasterPlacesService;

@RestController
public class MasterPlacesController {
    @Autowired
    private MasterPlacesService masterPlacesService;

    @RequestMapping("/masterplaces")
    public Map<String, Object> getAllMasterPlaces()
    {
        return masterPlacesService.getAllMasterPlaces();
    }

    @RequestMapping(method = RequestMethod.POST, value="/masterplaces")
    public Map<String, Object> addClasses(@RequestBody MasterPlaces masterplaces)
    {
        return masterPlacesService.addMasterPlaces(masterplaces);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/masterplaces/{id}")
    public Map<String, Object> DeleteClasses(@PathVariable String id)
    {
        return masterPlacesService.deleteMasterPlaces(id);
    }
}
