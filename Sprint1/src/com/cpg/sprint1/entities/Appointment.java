package com.cpg.sprint1.entities;

import java.sql.Date;

public class Appointment {

	public Appointment(User user, int appointmentId, Test test, Date datetime, String approved) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.test = test;
		this.datetime = datetime;
		this.approved = approved;
	}
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	private int appointmentId;
	private Test test;
	private Date datetime;
	private String approved;
}
