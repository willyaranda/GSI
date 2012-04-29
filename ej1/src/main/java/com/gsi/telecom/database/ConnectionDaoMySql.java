package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This Class implements the ConnectionDao interface for MySql DB
 * 
 * @author willyaranda
 * 
 */
public class ConnectionDaoMySql implements ConnectionDao {

	// Data to connect to MySQL server on localhost
	String url = "jdbc:mysql://localhost/telecom";
	String user = "root"; // Security rules!
	String password = "";

	Connection conn = null;

	@Override
	public Connection getConnection() throws SQLException {
		try {
			// Load the class for accessing MySql from JDBC
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn = DriverManager.getConnection(url, user, password);
	}
}
