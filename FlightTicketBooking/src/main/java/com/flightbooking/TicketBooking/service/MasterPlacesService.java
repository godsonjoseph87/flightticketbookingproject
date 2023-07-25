package com.flightbooking.TicketBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flightbooking.TicketBooking.util.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.TicketBooking.bean.MasterPlaces;
import com.flightbooking.TicketBooking.repository.MasterPlacesRepository;

@Service
public class MasterPlacesService {
    @Autowired
    public MasterPlacesRepository masterPlaceRepo;

    public Map<String, Object> getAllMasterPlaces()
    {
        List<MasterPlaces> masterplaces = new ArrayList<>();
        masterPlaceRepo.findAll().forEach(masterplaces::add);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, masterplaces);
    }

    public Map<String, Object> addMasterPlaces(MasterPlaces masterplaces) {
        masterPlaceRepo.save(masterplaces);
        return JsonResponseUtil.createJsonResponse("Data Added successfully", 200, "");
    }

    public Map<String, Object> deleteMasterPlaces(String id) {
        masterPlaceRepo.deleteById(id);
        return JsonResponseUtil.createJsonResponse("Data Deleted successfully", 200, "");
    }
}
