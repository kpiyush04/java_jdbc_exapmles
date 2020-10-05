package net.java.postgresql;

import java.sql.Connection;
import java.sql.Statement;

public class insert_data {
	
	public void data_inster() {
		Connection c = null;
		Statement stmt = null;
		String ins_query = null;
		
		try {
			
			//reestablishing the connection
			JDBC_ques sqlConnect = new JDBC_ques();
			c = sqlConnect.connect1();
			
			c.setAutoCommit(false);
			
			stmt = c.createStatement();
			
			
			//queries to insert data in table
			ins_query = "INSERT INTO employee (UserID, Password, Name, IncorrectAttempts, LockStatus, UsetType)"
					+ "VALUES ('AB1001', 'AB1001', 'Hari', 0, 0, 'Admin');";
			stmt.executeUpdate(ins_query);
			ins_query = "INSERT INTO employee (UserID, Password, Name, IncorrectAttempts, LockStatus, UsetType)"
					+ "VALUES ('TA1002', 'TA1002', 'Prasath', 0, 0, 'Emaployee');";
			stmt.executeUpdate(ins_query);
			ins_query = "INSERT INTO employee (UserID, Password, Name, IncorrectAttempts, LockStatus, UsetType)"
					+ "VALUES ('RS1003', 'RS1003', 'Ganesh', 0, 0, 'Employee');";
			stmt.executeUpdate(ins_query);
			
			stmt.close();
			c.commit();
			c.close();
			
			System.out.println("inserted");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		//calling data_inster
		insert_data sqlinsert = new insert_data();
		sqlinsert.data_inster();

	}

}
