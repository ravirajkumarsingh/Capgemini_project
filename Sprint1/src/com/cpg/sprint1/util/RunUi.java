package com.cpg.sprint1.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.cpg.sprint1.DaoImpl.AppointmentDaoImpl;
import com.cpg.sprint1.DaoImpl.Diagnostic_centerDaoImpl;
import com.cpg.sprint1.DaoImpl.TestDaoImpl;
import com.cpg.sprint1.DaoImpl.UserDao;
import com.cpg.sprint1.ServiceImpl.AppointmentServiceImpl;
import com.cpg.sprint1.ServiceImpl.Diagnostic_centerServiceImpl;
import com.cpg.sprint1.ServiceImpl.ServiceImpl;
import com.cpg.sprint1.ServiceImpl.TestServiceImpl;
import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.entities.Test;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.exceptions.*;
import com.cpg.sprint1.services.IAppointmentService;
import com.cpg.sprint1.services.IDiagnostic_centerService;
import com.cpg.sprint1.services.IService;
import com.cpg.sprint1.services.ITestService;


public class RunUi {
	public static Scanner s=new Scanner(System.in);
	public static IService service= new ServiceImpl(new UserDao());
	public static IDiagnostic_centerService service1= new Diagnostic_centerServiceImpl(new Diagnostic_centerDaoImpl() );
	public static ITestService service2 = new TestServiceImpl(new TestDaoImpl());
	public static IAppointmentService service3 = new AppointmentServiceImpl(new AppointmentDaoImpl());
	
	public static void main(String[] args) {
		System.out.println("1. Register");
		System.out.println("2. Login");
		int i = s.nextInt();
		if(i==1)
			register();
		else {
			String s1= login();
			validate(s1);
		}
	}
	
	public static void validate(String s1) {
		if(s1.equalsIgnoreCase("admin")) 
			admin();
		else
			customer();
	}

	
	public static void register() {
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
		System.out.println("Enter the User_Role (admin or customer)");
		String a8 = s.next();
		User user = new User(a2,a3,a4,a5,a6,a7,a8);
		System.out.println(service.register(user));
	}
	
	public static void customer() {
		try {
			do {
				System.out.println("1 Make an Appointment.");
				System.out.println("2 Exit");
				int ch = s.nextInt();
				switch(ch) {
				case 1: 
					try {
						System.out.println("Enter the date in format dd/MM/yyyy");
						String idate = s.next();
						Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(idate);
						service.makeAppointment(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
						break;
				case 2: System.out.println("Thank you visit again");
						System.exit(0);
				}
			}while(true);
		}catch(AppointmentNotFoundException e) {
			System.out.println("Appointment not found");
	}catch(CenterNotFoundException c) {
		System.out.println("Center not found");
	}catch(NullArgumentException n) {
		System.out.println("Null Argument is found");
	}catch(TestNotFoundException t) {
		System.out.println("Test is not Found");
	}
	}
	
	public static void admin() {
		try {
			do {
			System.out.println("1 Remove Appointment");
			System.out.println("2 Approve Appointment");
			System.out.println("3 Add Test");
			System.out.println("4 Remove Test");
			System.out.println("5 Add Center");
			System.out.println("6 Remove Center");
			System.out.println("7 Exit");
			System.out.println("Enter choice: ");
			int ch= s.nextInt();
			switch(ch) {
			case 1: System.out.println("*******Remove Appointment********");
					System.out.println("Enter appointment id");
					Double id = s.nextDouble();
					service3.removeAppointment(id);
					break;
					
			case 2: System.out.println("*******Approve Appointment********");
					System.out.println("Enter appointment id");
					Double id1 = s.nextDouble();
					System.out.println("Enter status(Yes or No):");
					String status= s.next(); 
					System.out.println(service3.approveAppointment(id1,status));
					break;
					
			case 3:	System.out.println("************Add Test************");
					System.out.println("Enter testId");
					String testid = s.next();
					System.out.println("Enter testName");
					String testname = s.next();
					Test test = new Test(testid,testname);
					System.out.println(service2.addTest(test));
					break;
					
			case 4: System.out.println("**********Remove Test********");
					System.out.println("Enter testId");
					String testid1 = s.next();
					if(service2.removeTest(testid1)) {
						System.out.println("Test Deleted");
					}
					else {
						System.out.println("Test not Deleted");
					}
					break;
					
			case 5: System.out.println("**************Add Center************");
					System.out.println("Enter the CenterName");
					String cen2 = s.next();
					System.out.println("Enter the Contact Details");
					int contact = s.nextInt();
					System.out.println("Enter the Address");
					String address = s.next();
					Diagnostic_center center = new Diagnostic_center(cen2, contact, address);
					System.out.println(service1.addCenter(center));
					break;
			
			case 6: System.out.println("Remove Center");
					System.out.println("Enter the centerId");
					String cen = s.next();
					if(service1.removeCenter(cen)) {
						System.out.println("Center Removed");
					}
					else {
						System.out.println("Center not Removed");
					}
					break;
			case 7 : System.out.println("Want to Exit");
					System.exit(0);
					
			default: System.out.println("Enter valid choice.");
					break;
			}
			}while(true);
		} catch(AppointmentNotFoundException e) {
			System.out.println("Appointment not found");
	}catch(CenterNotFoundException c) {
		System.out.println("Center not found");
	}catch(NullArgumentException n) {
		System.out.println("Null Argument is found");
	}catch(TestNotFoundException t) {
		System.out.println("Test is not Found");
	}
}
	
	public static String login() {
		System.out.println("Enter the UserId");
		String a1=s.next();
		System.out.println("Enter the UserPassword");
		String a2 = s.next();
		User u = service.validateUser(a1,a2);
		System.out.println("Welcome "+u.getUserName()+"To the HealthCare System");
		return u.getUser_role();
	}
}
