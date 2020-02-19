package com.cpg.sprint1.ServiceImpl;

import java.sql.Date;
import java.util.List;

import com.cpg.sprint1.DaoImpl.AppointmentDaoImpl;
import com.cpg.sprint1.dao.IAppointmentDao;
import com.cpg.sprint1.entities.Appointment;
import com.cpg.sprint1.exceptions.AppointmentNotFoundException;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.IAppointmentService;

public class AppointmentServiceImpl implements IAppointmentService {
	IAppointmentDao dao;

	public AppointmentServiceImpl(IAppointmentDao dao) {
		this.dao = dao;
	}

	@Override
	public String addAppointment(Date date) {
		if (date == null)
			throw new NullArgumentException("Null Argument entered");
		return dao.addAppointment(date);
	}

	@Override
	public boolean removeAppointment(Double id) {
		if (id == null)
			throw new AppointmentNotFoundException("No appointment found");
		return dao.removeAppointment(id);
	}

	@Override
	public List<Appointment> appList(Date app_date) {

		return dao.appList(app_date);
	}

	@Override
	public String approveAppointment(Double id, String status) {
		if (AppointmentDaoImpl.appList.size() == 0)
			return "No appoinments to approve";
		if (AppointmentDaoImpl.appList.size() == 10)
			return "You cannot approve more than 10 appointments per day";
		return dao.approveAppointment(id, status);
	}
}