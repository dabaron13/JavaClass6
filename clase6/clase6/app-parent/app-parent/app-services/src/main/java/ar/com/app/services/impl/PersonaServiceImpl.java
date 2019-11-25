package ar.com.app.services.impl;

import ar.com.app.dao.PersonaDAO;
import ar.com.app.domain.Persona;
import ar.com.app.services.PersonaService;

public class PersonaServiceImpl implements PersonaService {
	private PersonaDAO pd;

	@Override
	public void crearPersona(Persona p) throws Exception {
	
		pd.insertar(p);
	}

	@Override
	public void eliminarPersona(int id) throws Exception {
		pd.eliminar(id);
	}

}
