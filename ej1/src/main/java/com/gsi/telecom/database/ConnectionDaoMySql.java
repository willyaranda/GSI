package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDaoMySql {
	
	String url = "jdbc:mysql://localhost/telecom";
	String user = "root";
	String password = "";
	
	Connection conn = null;
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn = DriverManager.getConnection(url, user, password);
	}
}

