package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	private final static String URL = "jdbc:mysql://localhost/libreria";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Connection conexion = null;
		
		// comprobar que tengamos el .jar de MySQL
		Class.forName("com.mysql.jdbc.Driver");
		
		//establecer conexion
		conexion = DriverManager.getConnection(URL, USUARIO, PASS);
		
		return conexion;
	};
	

}
