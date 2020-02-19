package com.cpg.sprint1.DaoImpl;

import java.sql.*;
import java.util.*;

import com.cpg.sprint1.connection.MyDBConnection;
import com.cpg.sprint1.dao.IDiagnostic_centerDao;
import com.cpg.sprint1.entities.Diagnostic_center;

public class Diagnostic_centerDaoImpl implements IDiagnostic_centerDao {
	Connection con= MyDBConnection.getConnection();
	@Override
	public String addCenter(Diagnostic_center dc) {
		try {
			PreparedStatement ps= con.prepareStatement("insert into diagnostic_center values(?,?,?)");
			ps.setString(1, dc.getCenterName());
			ps.setDouble(2, dc.getContact_no());
			ps.setString(3, dc.getAddress());
			int a= ps.executeUpdate();
			if(a>0)
				return "Center added successfully!";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Unable to add center";
	}

	@Override
	public boolean removeCenter(String centerId) {
		try {
			PreparedStatement ps= con.prepareStatement("delete from diagnostic_center where center_id=?");
			ps.setString(1, centerId);
			int a= ps.executeUpdate();
			if(a>0)
				return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Diagnostic_center> centerList(Diagnostic_center dc) {
		List<Diagnostic_center> centerList= new ArrayList<>();
		try {
			Statement s= con.createStatement();
			ResultSet rs= s.executeQuery("select * from diagnostic_center");
			while(rs.next()) {
				Diagnostic_center center = new Diagnostic_center();
				center.setCenterId(rs.getString(1));
				center.setCenterName(rs.getString(2));
				center.setContact_no(rs.getDouble(3));
				center.setAddress(rs.getString(4));
				centerList.add(center);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return centerList;
	}

}