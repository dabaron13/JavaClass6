package ar.com.educacionit.fileparse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.app.domain.Producto;

public class FileParser {

	private String nombreArchivo;
	
	public FileParser(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public List<Producto> parsearArchivo() throws FileNotFoundException, IOException {
		
		File f = new File(nombreArchivo);
		
		BufferedReader in = new BufferedReader(new FileReader(f));
		
		String lineaLeida = null;
				
		List<Producto> listaDeProductos = new ArrayList<>();
		
		while( (lineaLeida =  in.readLine()) != null) {
			
			//1;
			//pendrive 16gb;
			//100
			String[] array = lineaLeida.split(";");
			
			Producto prducto = new Producto(Long.parseLong(array[0]),
											array[1],
											Double.parseDouble(array[2].trim()));
			listaDeProductos.add(prducto);
		}
		
		in.close();
		
		return listaDeProductos;
	}
}
