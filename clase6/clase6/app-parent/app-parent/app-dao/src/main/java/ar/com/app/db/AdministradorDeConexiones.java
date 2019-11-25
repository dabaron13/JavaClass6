package ar.com.app.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	
	public static Connection obtenerConexion() throws Exception
	{
	 
	        // Establece el nombre del driver a utilizar
	        String dbDriver = "com.mysql.cj.jdbc.Driver";
	    	
	    	// Establece la url y base de datos a utilizar
	        String dbConnString = "jdbc:mysql://localhost/cafe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    	
	    	// Establece el usuario de la base de datos
	        String dbUser = "root";
	       
	        // Establece la contrasea de la base de datos
	        String dbPassword = "";
	       
	        // Establece el driver de conexion
	        Class.forName(dbDriver).newInstance();
	       
	        // Retorna la conexion
	        Connection conn =  DriverManager.getConnection(dbConnString, dbUser, dbPassword);
	        return conn;
		}
	 


}
