package com.flightbooking.TicketBooking.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String bookingid;
	private String cardno;
	private String cvv;
	private String expirydate;
	
	
	
	public Payments() {
		
	}
	
	
	public Payments(Long id, String bookingid, String cardno, String cvv, String expirydate) {
		super();
		this.id = id;
		this.bookingid = bookingid;
		this.cardno = cardno;
		this.cvv = cvv;
		this.expirydate = expirydate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	
	
	

}
