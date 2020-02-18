package com.cpg.sprint1.ServiceImpl;

import java.sql.Date;

import com.cpg.sprint1.DaoImpl.UserDao;
import com.cpg.sprint1.dao.IUser;
import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.entities.Test;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.services.IService;

public class ServiceImpl implements IService{

	IUser dao = new UserDao();
	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		if(user.getUserId().length()>=3) {
			Double num=Math.random();
			String id=user.getUserId().substring(0,3)+num.toString().substring(2,6);
			user.setUserId(id);
			return dao.register(user);
		}
		else {
			return "User not created!";
		}
	}

	@Override
	public String makeAppointment(User user, Test test, Diagnostic_center center, Date date_time) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean approveAppointment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User validateUser(String user_id, String user_password) {
		if(user_id.length()>2 && user_password.length()>=3 || user_password.length()<9) {
			dao.validateUser(user_id, user_password);
		}
		return ;
	}

}
