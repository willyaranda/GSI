package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDaoDerby {

	/* the default framework is embedded */
	// private String framework = "embedded";
	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private String protocol = "jdbc:derby:";
	String dbName = "telecom"; // the name of the database

	Connection conn = null;

	public Connection getConnection() throws SQLException {
		try {
			Class.forName(driver).newInstance();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn = DriverManager.getConnection(protocol + dbName
				+ ";create=true");
	}
}
