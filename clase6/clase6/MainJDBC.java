package ar.com.app.mains;

import ar.com.app.domain.Producto;
import ar.com.app.services.ProductoService;
import ar.com.app.services.impl.ProductoServiceImpl;

public class MainJDBC {

	public static void main(String[] args) {
		//instancio servicio
		ProductoService ps = new ProductoServiceImpl();
		
		//creo objeto producto
		Producto p = new Producto("pendriver 16 gb", 155.5d);
		p.setCodigo("001");
		p.setTitulo("pendriver");
		
		try {
			ps.crearProducto(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
