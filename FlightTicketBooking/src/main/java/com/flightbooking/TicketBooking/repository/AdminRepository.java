package com.flightbooking.TicketBooking.repository;

import com.flightbooking.TicketBooking.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.TicketBooking.bean.Admin;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String>{

    @Query(value="select * from admin where username=?1 and password=?2", nativeQuery = true)
    public List<Admin> getAdminByUserNameAndPassword(String username, String password);
}
