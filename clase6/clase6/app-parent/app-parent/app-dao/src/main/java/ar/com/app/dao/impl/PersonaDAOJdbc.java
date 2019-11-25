package ar.com.app.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import ar.com.app.dao.PersonaDAO;
import ar.com.app.db.AdministradorDeConexiones;
import ar.com.app.domain.Persona;


public class PersonaDAOJdbc implements PersonaDAO {
	
	public  void insertar(Persona p) throws Exception {
		Connection con = AdministradorDeConexiones.obtenerConexion();
		String sql = "insert into personas (nombre, apellido, edad) values ('" + p.getNombre() +
				"', '"+ p.getApellido() + "', " + p.getEdad()+")";
		Statement st = con.createStatement();
		st.execute(sql);
		st.close();
		con.close();
	}
	
	
	public  void modificar(Persona p) throws Exception {
		Connection con = AdministradorDeConexiones.obtenerConexion();
		String sql = "update personas set nombre ='" + p.getNombre() +"', apellido = '"+ p.getApellido() +
				"', edad=" + p.getEdad()+" where id = " + p.getId();
		Statement st = con.createStatement();
		st.execute(sql);
		st.close();
		con.close();
	}
	
	public  void eliminar(int id) throws Exception {
		Connection con = AdministradorDeConexiones.obtenerConexion();
		String sql = "delete from personas where id = "+id;
		Statement st = con.createStatement();
		st.execute(sql);
		st.close();
		con.close();
	}
	
	public  Persona getPersona(int idPersona) throws Exception {
		Connection con = AdministradorDeConexiones.obtenerConexion();
		String sql = "select * from personas where id = "+idPersona;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		Persona p = new Persona();
		if (rs.next()) {
			int id = rs.getInt("id");
			int edad = rs.getInt("edad");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			
			p.setEdad(edad);
			p.setId(id);
			p.setNombre(nombre);
			p.setApellido(apellido);
		}
		st.close();
		con.close();
		return p;
	}
}
