package com.flightbooking.TicketBooking.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	private String id;
	private String name;
	private int classid;
	private String address;
	
	
	public Student() {
		
	}
	public Student(String id, String name, int classid, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.classid = classid;
	}
	
	 @Override
	 public String toString() {
	    return "{" +
	             "id='" + id + '\'' +
	             ", name='" + name + '\'' +
	             ", classid=" + classid +
	            '}';
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
