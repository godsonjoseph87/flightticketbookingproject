package com.flightbooking.TicketBooking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.TicketBooking.bean.Payments;
import com.flightbooking.TicketBooking.service.PaymentService;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/getPaymentDetails")
    public Map<String, Object> getAllPaymentDetails()
    {
        return paymentService.getAllPaymentDetails();
    }

    @RequestMapping(method = RequestMethod.GET, value="/getPaymentDetails/{id}")
    public Map<String, Object> getPaymentDetails(@PathVariable String id)
    {
        return paymentService.getPaymentDetails(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/savepaymentdetails")
    public Map<String, Object> addPaymentDetails(@RequestBody Payments payments)
    {
        return paymentService.addPaymentDetails(payments);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/paymentdetails/{id}")
    public Map<String, Object> deletePaymentDetails(@PathVariable String id)
    {
        return paymentService.deletePaymentDetails(id);
    }
}
