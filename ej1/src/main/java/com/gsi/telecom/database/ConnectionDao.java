package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Functions that all classes implementing this must have. This ensures that all
 * concrete classes that want to connect to a DB should have this methods
 * 
 * @author willyaranda
 * 
 */
public interface ConnectionDao {
	/**
	 * Returns a Connection to the DB
	 * 
	 * @return a Connection to the DB
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException;
}
