package es.willyaranda.ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.TestCase;

public class TestMySQL extends TestCase {

	public void testConnection()  {
		String url = "jdbc:mysql://localhost/contabilidad";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			String orden = "select * from cliente c order by c.apellido1, c.apellido2, c.nombre";
			ResultSet rs = conn.createStatement().executeQuery(orden);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
