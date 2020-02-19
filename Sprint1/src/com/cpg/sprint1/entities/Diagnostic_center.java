package com.cpg.sprint1.entities;

import java.util.List;

public class Diagnostic_center {

	public Diagnostic_center() {
		
	}
	
	public Diagnostic_center(String centerName, double contact_no, String address) {
		super();
		this.centerName = centerName;
		this.contact_no = contact_no;
		this.address = address;
	}
	private String centerName;
	private double contact_no;
	private String centerId;
	List<Test> listofTests;
	List<Appointment> appointmentList;
	public double getContact_no() {
		return contact_no;
	}
	public void setContact_no(double d) {
		this.contact_no = d;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public List<Test> getListofTests() {
		return listofTests;
	}
	public void setListofTests(List<Test> listofTests) {
		this.listofTests = listofTests;
	}
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
