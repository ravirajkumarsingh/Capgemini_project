package com.cpg.sprint1.entities;

import java.util.List;

public class User {
	public User(String userName,String emailId, String userPassword, int contactNo, 
			String gender, int age,String user_role) {
		super();
		this.user_role = user_role;
		this.gender = gender;
		this.age = age;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}
	public User() {
		
	}

	private String user_role;
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Diagnostic_center> getCenterList() {
		return centerList;
	}
	public void setCenterList(List<Diagnostic_center> centerList) {
		this.centerList = centerList;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	private List<Diagnostic_center> centerList;
	private String userPassword;
	private String userName;
	private int contactNo;
	private String userRole;
	private String emailId;
}
