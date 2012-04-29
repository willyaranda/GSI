package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This Class implements the ConnectionDao interface for Derby DB
 * 
 * @author willyaranda
 * 
 */
public class ConnectionDaoDerby implements ConnectionDao {

	// Data to connect to derbyDB
	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private String protocol = "jdbc:derby:";
	String dbName = "telecom";

	Connection conn = null;

	@Override
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
