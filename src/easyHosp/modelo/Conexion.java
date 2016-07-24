package easyHosp.modelo;

import java.sql.*;

public class Conexion {	
	// base de datos credenciales
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
		
	//JDBC driver nombre y base de datos URL
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/prueba";
		
	// init connection object
    protected Connection conexion;
    
    
 // connect database
    public Connection conectar() throws ClassNotFoundException {
    	this.conexion = null;
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return conexion;
    }
	
	// disconnect database
    public void cerrar() throws SQLException {
    	if (conexion != null) {
    		conexion.close();
        }
    }
	
	

}