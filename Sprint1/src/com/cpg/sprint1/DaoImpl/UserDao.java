package com.cpg.sprint1.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cpg.sprint1.ServiceImpl.AppointmentServiceImpl;
import com.cpg.sprint1.connection.MyDBConnection;
import com.cpg.sprint1.dao.IUser;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.services.IAppointmentService;

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
	public String makeAppointment(Date date_time) {
		 IAppointmentService service3 = new AppointmentServiceImpl(new AppointmentDaoImpl());
		return service3.addAppointment(date_time);
	}	
}
