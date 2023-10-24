package com.sql;

import java.sql.SQLException;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		ResultData rd = new ResultData();
		
		    System.out.println("Enter username >>");
		    String username=sc.next();
			
			  System.out.println("enter password >>");
			String password=sc.next();
			rd.displayResult(username, password);
	        }
			
		
}






