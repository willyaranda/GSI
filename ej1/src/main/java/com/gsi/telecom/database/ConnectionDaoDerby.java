package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDaoDerby {
	
	String url = "jdbc:derby://localhost:1527/dbtest";
	
	Connection conn = null;
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn = DriverManager.getConnection(url);
	}
}

