package com.cpg.sprint1.entities;

import java.util.Date;

public class Appointment {
	private double appointmentId;
	private String status;
	private java.sql.Date app_date;

	public Appointment(double appointmentId, String status) {
		this.appointmentId = appointmentId;
		this.status = status;
	}

	public Appointment() {
	}

	public java.sql.Date getDate() {
		return app_date;
	}

	public void setDate(Date date) {
		this.app_date = (java.sql.Date) date;
	}

	public double getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(double appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}