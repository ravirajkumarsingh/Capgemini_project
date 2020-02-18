package com.cpg.sprint1.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.cpg.sprint1.connection.MyDBConnection;
import com.cpg.sprint1.dao.IUser;
import com.cpg.sprint1.entities.Appointment;
import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.entities.Test;
import com.cpg.sprint1.entities.User;

public class UserDao implements IUser{
	private Connection con = MyDBConnection.getConnection();
	/**
	 * For the connection.
	 */
	public User validateUser(String user_id, String user_password) {
		User u =null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from user_ where user_id=? and user_password=?");
			ps.setString(1, user_id);
			ps.setString(2, user_password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return u;
			}
		} catch (SQLException e) {
			return u;
		}
		return u;
		
	}
	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		/**
		 * 
		 */
		try {
			PreparedStatement pst = con.prepareStatement("insert into user_ values(?,?,?,?,?,?,?,0,?)");
			pst.setString(1, user.getUserId());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getEmailId());
			pst.setString(4, user.getUserPassword());
			pst.setInt(5, user.getContactNo());
			pst.setString(6, user.getGender());
			pst.setInt(7, user.getAge());
			pst.setString(8, user.getUser_role());
			pst.executeUpdate();
			int a=pst.executeUpdate();
			if(a>0) 
				return "Welcome to the healthcare system. Your UserId is="+user.getUserId();
			else
				return "User Not created!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "User not created.";
		}
	}

	@Override
	public String makeAppointment(User user, Test test, Diagnostic_center center, Date date_time) {
		// TODO Auto-generated method stub
		/*
		try {
			PreparedStatement pst2 = con.prepareStatement("select appointment_id from user_ where user_id=?");
			pst2.setString(1, user.getUserId());
			ResultSet rs1= pst2.executeQuery();
			System.out.println(rs1.getString(1));
			PreparedStatement pst3 = con.prepareStatement("select test_id from diagnostic_center where appointment_id=?");
			PreparedStatement pst = con.prepareStatement("select test_name from test where test_id in (select test_id from diagnostic_center where appointment_id in (select appointment_id from user_ where user_id=?))");
			pst.setString(1, user.getUserId());
			ResultSet rs = pst.executeQuery();
			System.out.println(rs.getInt(1));
			PreparedStatement pst1 = con.prepareStatement("update appointment  set date_time=? where appointment_id=?");
			pst1.setDate(1, appointment.getDatetime());
			pst1.setInt(2, appointment.getAppointmentId());
			int a = pst1.executeUpdate();
			if(a>0) {
				return "Appointment is done on="+appointment.getDatetime();
			}
			else {
				return "Enter Valid IDs";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Enter valid IDs";
		}*/
//		PreparedStatement pst = con.prepareStatement("select ")
		
		return null;
	}

	@Override
	public boolean approveAppointment() {
		// TODO Auto-generated method stub
		
		return false;
	}	
}
