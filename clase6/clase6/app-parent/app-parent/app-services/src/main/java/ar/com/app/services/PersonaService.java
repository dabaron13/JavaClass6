package ar.com.app.services;

import ar.com.app.domain.Persona;


public interface PersonaService {
	
	public void crearPersona(Persona p) throws Exception;

	public void eliminarPersona(int id) throws Exception;
	
}
