package com.gsi.telecom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.TestCase;

public class TestMySQL extends TestCase {

	public void testConnection()  {
		String url = "jdbc:mysql://localhost/telecom";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection conn = null;
		ResultSet rs = null;
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
		}
	}
	
	public void testInsertProduct() {
		
	}
	
	public void testDeleteProduct() {
		
	}
	
	public void testSelectProduct() {
		
	}
	
	public void testFindProduct() {
		
	}

}
