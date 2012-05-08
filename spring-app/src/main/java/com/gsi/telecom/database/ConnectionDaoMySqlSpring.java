package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectionDaoMySqlSpring {
	
	private String database;
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String user;
	private String password;
	
    public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	/** 
     * Registra dinámicamente el driver y devuelve una conexión con la BD
     * @return una conexión con la BD
     */
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// Stablish connection
		Connection con = DriverManager.getConnection( "jdbc:mysql://localhost/"+ getDatabase(), getUser(), getPassword() );
		return  con;
	}
	
    /** 
     * Close connection
     * @param conexión a cerrar
     */
	public void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
    /** 
     * Print connection and DB details
     * @param conexión cuya información se desea mostrar
     * @throws ClassNotFoundException 
     */
	public void printConnection() throws SQLException, ClassNotFoundException {

		Connection con = getConnection();
		
	    // Obtener metadatos de base de datos
	    DatabaseMetaData dbmd = con.getMetaData();

	    /*
	    Obtengo el ResultSet de las tablas:
	       El tercer argumento puede especificar el nombre de la tabla
	       El cuarto argumento especifica los tipos (TABLE, VIEW, etc.). null: todos
	    */
	    ResultSet rs = dbmd.getTables( null, null, null, new String[]{"TABLE"} );

	    // Obtenemos el ResultSetMetaData a partir del anterior, además obt. núm. columnas
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int num_cols = rsmd.getColumnCount();

	    // Mostrar información general
	    System.out.println( "--------- CARACTERISTICAS GENERALES ---------------" );
	    System.out.println( "Nombre de BD: " + dbmd.getDatabaseProductName() );
	    System.out.println( "Versión de BD: " + dbmd.getDatabaseProductVersion() );
	    System.out.println( "Nombre de controlador: " + dbmd.getDriverName() );
	    System.out.println( "Versión de controlador: " + dbmd.getDriverVersion() );
	    System.out.println( "Versión mayor de controlador JDBC: " + dbmd.getJDBCMajorVersion() );
	    System.out.println( "Versión menor de controlador JDBC: " + dbmd.getJDBCMinorVersion() );
	    System.out.println( "Statements simultaneos: " + dbmd.getMaxStatements() );
	    System.out.println( "Soporte SQL92: " + dbmd.supportsANSI92FullSQL() );
	    System.out.println( "Soporte de SCROLL_SENSITIVE: " +
				dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
	    System.out.println( "Además actualiza BD: " +
				dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));

	    System.out.println( "--------- CARACTERISTICAS DE CADA TABLA ------------" );

    	// Recorremos las características de cada tabla
	    while ( rs.next() ) {
	    	for ( int i = 1; i <= num_cols; i++ ) {
	    		if ( i > 1 )
	    			System.out.print( ",  " );
	    		System.out.print( rsmd.getColumnLabel(i) + ": ");
	    		System.out.print( rs.getString(i) );

	    	}

	    	// Mostrar columnas de la tabla
	    	printTable( con, rs.getString(3) );
	    	System.out.println( "" );
	    }

	    rs.close();
	    closeConnection(con);
	}

    /** 
     * Muestra campos (columnas) de la tabla
     * @param con: conexión actual
     * @param table nombre de la tabla
     * @throws SQLException 
     */
    static void printTable( Connection con, String table ) throws SQLException {

	    // Ejecutar sentencia SELECT para la tabla
	    ResultSet rs_sel = con.createStatement().executeQuery("SELECT * FROM " + table );

	    // Obtenemos metadatos de la sentencia SELECT
	    ResultSetMetaData mdata_sel = rs_sel.getMetaData();
	    int num_cols_sel = mdata_sel.getColumnCount();

	    // Recorremos cada columna para mostrar sus características
	    for (int num_col_sel = 1; num_col_sel <= num_cols_sel; num_col_sel++) {
	    	System.out.println("");
	    	// Mostrar nombre de columna
	    	System.out.print("\t" + mdata_sel.getColumnLabel(num_col_sel));
	    	// Mostrar tipo Java
	    	System.out.print(" (Tipo Java:" + mdata_sel.getColumnClassName(num_col_sel) +")");
	    	// Mostrar tipo SQL
	    	System.out.print(" (Tipo SQL:" + mdata_sel.getColumnTypeName(num_col_sel) +")");
	    	// Mostrar tamaño
	    	System.out.print(" (Size=" + mdata_sel.getColumnDisplaySize(num_col_sel) +")");
	    }
	    rs_sel.close();
    }
}
