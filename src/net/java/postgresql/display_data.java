package net.java.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class display_data {
	
	public static void main(String[] args) {
		
		
		Connection c = null;
		Statement stmt = null;
		String display_query = null;

		
		try {
			
			//reestablishing the connection
			JDBC_ques sqlConnect = new JDBC_ques();
			c = sqlConnect.connect1();
			c.setAutoCommit(false);
			stmt = c.createStatement();
			
			//query for displaying data from table employee
			display_query = ( "SELECT * FROM employee;" );
			ResultSet rs = stmt.executeQuery(display_query);
			
			
			//fetching the data from the columns of the table
			while (rs.next()) {
				String user = rs.getString("UserID");
				String passwo = rs.getString("Password");
				String username = rs.getString("Name");
				int ia = rs.getInt("IncorrectAttempts");
				int ls = rs.getInt("LockStatus");
				String ut = rs.getString("UsetType");	
				System.out.println(user + ", " + passwo + ", " + username + ", " + ia + ", " + ls +", " + ut + ", ");
			}
			
			stmt.close();
			c.commit();
			c.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
