package ar.com.educacionit.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		Collection<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		
		Set<Integer> listaFiltrada = 
			lista.stream()
			.peek(x-> System.out.println("antes de filtrar " + x))
			.filter(x -> x >= 5)
			.collect(Collectors.toSet());
		
		System.out.println(listaFiltrada);
	}

}
