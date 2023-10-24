package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultData {
	Connection connection = null;
	PreparedStatement ps = null;
	
	public void displayResult(String username,String password) throws SQLException, ClassNotFoundException {
		
		
         Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mypractical","root","Sarvesh107");
		
			ps = connection.prepareStatement("SELECT score from student_result where username='?' and password = '?'");
			ps.setString(1, username);
			ps.setString(2,password);
			
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			System.out.println("Score is >> "+rs.getInt(4));
			}
			
			connection.close();
			ps.close();
			rs.close();
			
			
			

		
	}
	
	
	

}
