package com.miniproject;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String uname,password=" ";
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		
		for(int i = 1;i<=7;i++) {
			System.out.println("\nWelcome to console based application");
			System.out.println("1. Student Registration\n2.Student Login" + 
					"\n3.Display the list of questions\n4.Display Quiz result\n5.Display all students score as per ascending order\n6.Fetch student score by using id" + 
					"\n7.Add question with 4 options into database");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();


		switch(choice){
		case 1 :
			System.out.println("Enter First Name >>> ");
			String fname = sc.next();
			System.out.println("Enter Last Name >>> ");
			String lname = sc.next();
			System.out.println("Enter Username >>> ");
			uname = sc.next();
			System.out.println("Enter password >>> ");
			password = sc.next();
			System.out.println("Enter City >>> ");
			String city = sc.next();
			System.out.println("Enter Email Id >>> ");
			String email = sc.next();
			System.out.println("Enter Mobile Number >>> ");
			String mobileNo = sc.next();
			
			student.insertStudentDetails(fname, lname, uname, password, city, email, mobileNo);
			
		break;
			
		case 2 :
			System.out.println("Enter Username >>> ");
			uname = sc.next();
			System.out.println("Enter password >>> ");
			password = sc.next();
			student.checkStudentLoginCredential(uname,password);
		break;
		
		default :
			System.out.println("Invalid Input ....");
		
			}
		}
		
	}

}
