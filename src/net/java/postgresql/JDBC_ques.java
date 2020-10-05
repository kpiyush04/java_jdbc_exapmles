package net.java.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_ques {
	//using postgreSql as data base 
	
	public String url = "jdbc:postgresql://localhost/labdb";
	public String user = "postgres";
	public String password = "1204";
	
	
	// setting up connection
	public Connection connect1() {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(url, user, password);
			if (c!=null) {
				System.out.println("ok");
			} else {
				System.out.println("no");
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName()+": "+ e.getMessage() );
		}
		return c;
	}
	
	
	
	public static void main(String[] args) {
		
		//calling connect1 method
		JDBC_ques sqlConnect = new JDBC_ques();
		sqlConnect.connect1();
				
		
	}
}