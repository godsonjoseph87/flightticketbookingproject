package com.flightbooking.TicketBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.flightbooking.TicketBooking.util.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.TicketBooking.bean.Payments;
import com.flightbooking.TicketBooking.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    public PaymentRepository paymentRepo;

    public Map<String, Object> getAllPaymentDetails()
    {
        List<Payments> paymentdetails = new ArrayList<>();
        paymentRepo.findAll().forEach(paymentdetails::add);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, paymentdetails);
    }

    public Map<String, Object> getPaymentDetails(String id) {
        Optional<Payments> payments = paymentRepo.findById(id);
        return JsonResponseUtil.createJsonResponse("Data Fetched successfully", 200, payments);
    }

    public Map<String, Object> addPaymentDetails(Payments payment) {
        paymentRepo.save(payment);
        return JsonResponseUtil.createJsonResponse("Data Added successfully", 200, "");
    }

    public Map<String, Object> deletePaymentDetails(String id) {
        paymentRepo.deleteById(id);
        return JsonResponseUtil.createJsonResponse("Data Deleted successfully", 200, "");
    }
}
