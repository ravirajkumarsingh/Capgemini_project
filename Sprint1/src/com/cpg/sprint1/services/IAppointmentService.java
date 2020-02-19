package com.cpg.sprint1.services;

import java.sql.Date;
import java.util.List;

import com.cpg.sprint1.entities.Appointment;

public interface IAppointmentService {
public String addAppointment(Date date_time);
public boolean removeAppointment(Double id);
public List<Appointment> appList(Date app_date);
public String approveAppointment(Double id, String status);
}