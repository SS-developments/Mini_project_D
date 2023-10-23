package com.mini.project;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionTest {
	
	Connection conn = null;
	public Connection getConnectionDetails(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject_d","root","root@123456789");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}





