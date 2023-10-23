package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuizQuestions {
	Connection con = null;

	PreparedStatement pstmt = null;
	
	public void getResult(int result) throws SQLException {
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			con = databaseConnection.getConnectionDetails();
			
			pstmt = con.prepareStatement("insert into quizresult(quizresult)values(?)");
			
			pstmt.setInt(1, result);
			
			int i = pstmt.executeUpdate();
			System.out.println("Result is Recorded");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			pstmt.cancel();
		}
	}

	public void getQuizQuestions() throws SQLException {
		int marks = 0;
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			con = databaseConnection.getConnectionDetails();
			
			pstmt = con.prepareStatement("select * from quizquestions");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//for question and options
				System.out.println("Question " + rs.getInt(1) + " : " + rs.getString(2));
				System.out.println("a : " + rs.getString(3));
				System.out.println("b : " + rs.getString(4) );
				System.out.println("c : " + rs.getString(5) );
				System.out.println("d : " + rs.getString(6) );
				
				//for answer checking
				String answer = rs.getString(7);
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Your Answer : ");
				String userAnswer = sc.next();
				if(userAnswer.equals(answer)) {
					marks++;
				}
				System.out.println(".......................................");
			}
			System.out.println(marks);
			QuizQuestions quizQuestions = new QuizQuestions();
			quizQuestions.getResult(marks);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			pstmt.close();
		}
	}

	public static void main(String[] args) throws SQLException{
		
		System.out.println("-------------Quiz----------------");
		
		QuizQuestions quizQuestions = new QuizQuestions();
		quizQuestions.getQuizQuestions();

	}
}
