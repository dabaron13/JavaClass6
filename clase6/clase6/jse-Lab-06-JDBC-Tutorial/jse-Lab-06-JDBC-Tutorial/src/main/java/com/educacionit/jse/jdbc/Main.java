package com.educacionit.jse.jdbc;

public class Main {

	public static void main(String[] args) {

		Persona pepe = new Persona("Pepe", "Sanchez", 43);
		Persona fulano = new Persona("Juan", "Gomez", 53);
		try {
			PersonaDAO.inserta(pepe);
			PersonaDAO.inserta(fulano);
			Persona personita = PersonaDAO.getPersona(1);
			personita.setNombre("Maxi");
			PersonaDAO.modifica(personita);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ejercicio para delete, update, etc.
		Persona[] p = new Persona[10];
		p[0] = new Persona("danny","baron",10);
		p[1] = new Persona("lau","baron",11);
		p[2] = new Persona("tito","baron",12);
		p[3] = new Persona("jack","baron",13);
		p[4] = new Persona("mao","baron",14);
		p[5] = new Persona("lis","baron",15);
		p[6] = new Persona("diego","baron",16);
		p[7] = new Persona("heidi","baron",15);
		p[8] = new Persona("robin","baron",17);
		p[9] = new Persona("carlos","baron",18);
	
		/*
		for (int i = 0; i < p.length; i++) {
			
			p[i] = new Persona("nombre", "apellido", 20 + i);
			System.out.println(p[i]);
			
			
		}
		*/
		
		try {
			
			for (int i = 0; i < p.length; i++) {
				PersonaDAO.inserta(p[i]);
			}

			Persona prueba = PersonaDAO.getPersona(5);
			prueba.setNombre("leo");
			PersonaDAO.modifica(prueba);
			PersonaDAO.elimina(8);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}

}
