package com.mini.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ConnectionTest connectionTest = new ConnectionTest();
	
	public void insertStudentDetails(String fname,String lname,String city,String emailId,String mobileNo,String uname,String password) throws SQLException {
		try {
			
			conn = connectionTest.getConnectionDetails();
			String sql = "insert into student_register(firstname,lastname,emailId,city,mobileNo)values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, city);
			pstmt.setString(4, emailId);
			pstmt.setString(5, mobileNo);
			
			int i = pstmt.executeUpdate();
			
			if(i > 0) {
				System.out.println("Student Registration Done Successfully !!!!!!!!! ");
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
                    int userId = rs.getInt(1);
                    String sql1 = "insert into login(studId,username,password,userrole)values(?,?,?,?)";
        			pstmt = conn.prepareStatement(sql1);
        			pstmt.setInt(1, userId);
        			pstmt.setString(2, uname);
        			pstmt.setString(3, password);
        			pstmt.setInt(4, 2);
        			pstmt.executeUpdate();
                }
			}else {
				System.out.println("Student Registration Not Done..........");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			conn.close();
			pstmt.close();
		}
	}
	
	public void checkStudentLoginCredential(String uname,String password) throws SQLException {
	
		try {
			conn = connectionTest.getConnectionDetails();
			String selectsql = "select * from login where username = ? and password = ?";
			pstmt = conn.prepareStatement(selectsql);
			pstmt.setString(1, uname);
			pstmt.setString(2, password);
			
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					int studentId = rs.getInt("studId");
					//System.out.println(studentId);
					/*System.out.println(rs.getString(3));
					System.out.println(uname);
					System.out.println(rs.getString(4));
					System.out.println(password);*/
					if(rs.getString(3).equals(uname) && rs.getString(4).equals(password)) {
						System.out.println("Student Login Successfully !!!!!!!!!!");
					}else {
						System.out.println("Incorrect Credentials............");
					}
				}else {
					System.out.println("Incorrect Credentials............");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void displayQuestion() throws SQLException {
		
		
			
		
			try {
				conn = connectionTest.getConnectionDetails();
				Scanner sc = new Scanner(System.in);
				String selectsql1 = "select * from mcqs_questionary";
				pstmt = conn.prepareStatement(selectsql1);

				ResultSet rs = pstmt.executeQuery();
				int score = 0;
				while (rs.next()) {
					int id = rs.getInt("q_id");
					String question = rs.getString("question");
					String optionA = rs.getString("option1");
					String optionB = rs.getString("option2");
					String optionC = rs.getString("option3");
					String optionD = rs.getString("option4");
					int correctAnswer = rs.getInt("answer");

					System.out.println("Question " + id + ": " + question);
					System.out.println("1). " + optionA);
					System.out.println("2). " + optionB);
					System.out.println("3). " + optionC);
					System.out.println("4). " + optionC);

					System.out.print("Your answer (1/2/3/4): ");
					int userAnswer = sc.nextInt();

					if (userAnswer == correctAnswer) {
						score++;
					} else {
						score = score;
					}

				}
				 /*String updateQuery = "UPDATE student_register SET score = ? WHERE studentid = ?";
		           pstmt = conn.prepareStatement(updateQuery);
		           pstmt.setInt(1, score);
		           pstmt.setInt(2, studentId);
		           pstmt.executeUpdate();*/
			}catch(Exception e ) {
				e.printStackTrace();
			}finally {
				conn.close();
				pstmt.close();
			}
		
		
	}
	
	
	

}
