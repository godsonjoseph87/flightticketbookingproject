package com.flightbooking.TicketBooking.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flights {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int capacity;
	private String sourceid;
	private String airlineid;
	private String destinationid;
	private String time;
	private float price;
	
	
	public Flights() {
		
	}


	public Flights(Long id, String name, int capacity, String sourceid, String airlineid, String destinationid,
			String time, float price) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.sourceid = sourceid;
		this.airlineid = airlineid;
		this.destinationid = destinationid;
		this.time = time;
		this.price = price;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String getSourceid() {
		return sourceid;
	}


	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}


	public String getAirlineid() {
		return airlineid;
	}

	public void setAirlineid(String airlineid) {
		this.airlineid = airlineid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDestinationid() {
		return destinationid;
	}


	public void setDestinationid(String destinationid) {
		this.destinationid = destinationid;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}	

}
