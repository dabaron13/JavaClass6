package ar.com.educacionit.java8;

import ar.com.app.domain.Persona;
import ar.com.app.services.PersonaService;
import ar.com.app.services.impl.PersonaServiceImpl;


public class MainJDBC {

	public static void main(String[] args) {
		//instancio servicio
		PersonaService ps = new PersonaServiceImpl();
		
		//creo objeto producto
		Persona p = new Persona();
		p.setId(1);

		
		try {
			ps.crearPersona(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
