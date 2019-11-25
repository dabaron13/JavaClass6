package ar.com.app.dao;

import ar.com.app.domain.Persona;
import java.sql.SQLException;


public interface PersonaDAO {
	//firmo los metodos
	
	public void insertar (Persona p) throws Exception, SQLException;
	public Persona getPersona(int id) throws Exception, SQLException;
	public void eliminar (int id) throws Exception, SQLException;
	public void modificar (Persona p) throws Exception, SQLException;
	
		
	
}

