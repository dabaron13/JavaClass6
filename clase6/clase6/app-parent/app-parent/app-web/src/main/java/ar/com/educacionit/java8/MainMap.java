package ar.com.educacionit.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MainMap {

	public static void main(String[] args) {
		
		Collection<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);

		List<String> listaFiltrada = 
			lista.stream()
			.filter(x -> x < 3)
			.map(x -> new String("nuevo valor: "+x))
			.collect(Collectors.toList());
		
		System.out.println(listaFiltrada);
	}

}
