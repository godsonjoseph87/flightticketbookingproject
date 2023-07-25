package com.flightbooking.TicketBooking.controller;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.TicketBooking.bean.Admin;
import com.flightbooking.TicketBooking.bean.Student;
import com.flightbooking.TicketBooking.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(method = RequestMethod.POST, value="/validate/admin")
	public Map<String, Object> validateAdmin(@RequestBody Admin admin)
	{
		String username = admin.getUsername();
		String password = admin.getPassword();
		return adminService.validateAdmin(username, password); 
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/admin")
	public Map<String, Object> updateAdmin(@RequestBody Admin adminpassword)
	{
		Admin admin = new Admin();
		admin.setId("1");
		admin.setUsername("admin");
		admin.setEmail("admin@gmail.com");
		admin.setName("Admin");
		admin.setPassword(adminpassword.getPassword());

		return adminService.updateAdmin(admin);
	}

}
