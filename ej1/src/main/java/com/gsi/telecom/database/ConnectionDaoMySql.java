package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

	
	/*ResultSet rs = null;
	try {
		conn = DriverManager.getConnection(url, user, password);
		
		String orden = "select * from cliente c order by c.apellido1, c.apellido2, c.nombre";
		rs = conn.createStatement().executeQuery(orden);
		
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
		//Checking if conn or rs are null
		assertNotNull(conn);
		assertNotNull(rs);
	}*/

}

