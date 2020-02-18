package com.cpg.sprint1.util;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.cpg.sprint1.DaoImpl.UserDao;
import com.cpg.sprint1.ServiceImpl.ServiceImpl;
import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.entities.Test;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.services.IService;


public class RunUi {
	public static Scanner s=new Scanner(System.in);

	public static IService service= new ServiceImpl();
	public static void main(String[] args) {
		System.out.println("Enter the user_role");
		String s1 = s.next();
		RunUi runUi = new RunUi();
		runUi.validate(s1);
	}
	public static  String validate(String s1) {
		if(s1.equalsIgnoreCase("admin")) {
			admin();
		}
		else if(s1.equalsIgnoreCase("customer")) {
			System.out.println("1 For Register");
			System.out.println("2 For Login");
			System.out.println("Enter choice: ");
			int a = s.nextInt();
			if(a==1) {
				System.out.println("Enter UserId");
				String a1 = s.next();
				System.out.println("Enter the UserName");
				String a2 = s.next();
				System.out.println("Enter the UserEmail");
				String a3 = s.next();
				System.out.println("Enter the UserPassword");
				String a4 = s.next();
				System.out.println("Enter the Contact No");
				int a5 = s.nextInt();
				System.out.println("Enter the Gender");
				String a6 = s.next();
				System.out.println("Enter the Age");
				int a7 = s.nextInt();
				System.out.println("Enter the User_Role");
				String a8 = s.next();
				User user = new User(a1,a2,a3,a4,a5,a6,a7,a8);
				System.out.println(service.register(user));
			}
			else if(a==2) {
				login();
				}
			else {
				return "Enter valid Option";
			}
		}
		else {
			return "Role Not Defined.";
		}
	}
	
	public static void admin() {
		System.out.println("1 For add Appointment");
		System.out.println("2 For Remove Appointment");
		System.out.println("3 For Approve Appointment");
		System.out.println("4 For Add Test");
		System.out.println("5 For Remove Test");
		System.out.println("6 For Add Center");
		System.out.println("7 For Remove Center");
		System.out.println("Enter choice: ");
		int ch= s.nextInt();
		switch(ch) {
		case 1: System.out.println("Add Appointment");
				break;
		case 2: 
				break;
		case 3:
				break;
		case 4:	System.out.println("Add Test");
				System.out.println("Enter testId");
				String testid = s.next();
				System.out.println("Enter testName");
				String testname = s.next();
				Test test = new Test(testid,testname);
				System.out.println(service.addTest(test));
				break;
		case 5: System.out.println("Remove Test");
				System.out.println("Enter testId");
				String testid1 = s.next();
				if(service.removeTest(testid1)) {
					System.out.println("Test Deleted");
				}
				else {
					System.out.println("Test not Deleted");
				}
				break;
		case 6: System.out.println("Add Center");
				System.out.println("Enter CenterId");
				String cen1= s.next();
				System.out.println("Enter the CenterName");
				String cen2 = s.next();
				System.out.println("Enter the Contact Details");
				int contact = s.nextInt();
				System.out.println("Enter the Address");
				String address = s.next();
				Diagnostic_center center = new Diagnostic_center();
				System.out.println(service.addCenter(center));
				break;
		case 7: System.out.println("Remove Center");
				System.out.println("Enter the centerId");
				String cen = s.next();
				if(service.removeCenter(cen)) {
					System.out.println("Center Removed");
				}
				else {
					System.out.println("Center not Removed");
				}
				break;
		
		}
	}
	
	public static void  login() {
		int flag = 0;
		System.out.println("Enter the UserId");
		String a1=s.next();
		System.out.println("Enter the UserPassword");
		String a2 = s.next();
		service.validateUser(a1,a2);
			System.out.println("Enter the choice");
			
			
		}
		else
			System.out.println("Incorrect Credentials");
	}
}
