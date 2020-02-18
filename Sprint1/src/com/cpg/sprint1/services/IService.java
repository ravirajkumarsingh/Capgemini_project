package com.cpg.sprint1.services;

import java.sql.Date;

import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.entities.Test;
import com.cpg.sprint1.entities.User;

public interface IService {
	public User validateUser(String user_id,String user_password);
	public String register(User user);
	public boolean approveAppointment();
	String makeAppointment(User user, Test test, Diagnostic_center center, Date date_time);
}
