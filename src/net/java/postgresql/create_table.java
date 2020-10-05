package net.java.postgresql;

import java.sql.*;

public class create_table {
	
		//creating a method name table 
		public void table() {
			Connection c = null;
			Statement stmt = null;
			String create_query = null;
			try {
				
				//reestablishing the connection
				JDBC_ques sqlConnect = new JDBC_ques();
				c = sqlConnect.connect1();
				

				// creating a table in database
				stmt = c.createStatement();
				create_query = "CREATE TABLE employee (UserID VARCHAR(200) PRIMARY KEY, Password VARCHAR(200), Name VARCHAR(200), "
						+ "IncorrectAttempts INT, LockStatus INT, UsetType VARCHAR(200))";
				stmt.executeUpdate(create_query);
				stmt.close();
				c.close();
				System.out.println("done");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			

		}
		
		public static void main(String[] args) {
			
			//calling table method
			create_table sqltable = new create_table();
			sqltable.table();
		}
}
