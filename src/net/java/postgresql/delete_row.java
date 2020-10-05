package net.java.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class delete_row {

	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		String delete_query = null;
		String display_query = null;
		
		try {
			
			//reestablishing the connection with database
			JDBC_ques sqlConnect = new JDBC_ques();
			c = sqlConnect.connect1();
			c.setAutoCommit(false);
			
			stmt = c.createStatement();
			
			//query for displaying data from table employee
			delete_query = ( "DELETE FROM employee WHERE  Name = 'Hari';" );
			stmt.executeUpdate(delete_query);
			c.commit();
			
			//query for displaying data from table employee
			display_query = ( "SELECT * FROM employee;" );
			ResultSet rs2 = stmt.executeQuery(display_query);
			
			
			//fetching the data from the columns of the table
			while (rs2.next()) {
				String user = rs2.getString("UserID");
				String passwo = rs2.getString("Password");
				String username = rs2.getString("Name");
				int ia = rs2.getInt("IncorrectAttempts");
				int ls = rs2.getInt("LockStatus");
				String ut = rs2.getString("UsetType");	
				System.out.println(user + ", " + passwo + ", " + username + ", " + ia + ", " + ls +", " + ut + ", ");
			}
			rs2.close();
			stmt.close();
			c.commit();
			c.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}

	}

}


