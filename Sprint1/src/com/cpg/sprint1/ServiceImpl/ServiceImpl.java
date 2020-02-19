package com.cpg.sprint1.ServiceImpl;

import java.sql.Date;

import com.cpg.sprint1.DaoImpl.UserDao;
import com.cpg.sprint1.dao.IUser;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.IService;

public class ServiceImpl implements IService{

	IUser dao = new UserDao();
	public ServiceImpl(IUser dao) {
		this.dao=dao;
	}
	@Override
	public String register(User user) {
		if(user.getUserId()== null) {
			throw new NullArgumentException("Enter valid User_Id");
		}
		if(user.getUserId().length()>=3) {
			Double num=Math.random();
			String id=user.getUserId().substring(0,3)+num.toString().substring(2,6);
			user.setUserId(id);
			if(user.getEmailId().matches("[A-Za-z0-9_.]@[a-zA-Z].[a-zA-Z]{2,3}")) {
				return dao.register(user);
			}
		}
		return "User not created!";
	}

	@Override
	public String makeAppointment(Date date) {
		return dao.makeAppointment(date);
	}

	@Override
	public User validateUser(String user_id, String user_password) {
		if(user_id.length()>2 && user_password.length()>=3 || user_password.length()<9) {
			return dao.validateUser(user_id, user_password);
		}
		return null;
	}
}

