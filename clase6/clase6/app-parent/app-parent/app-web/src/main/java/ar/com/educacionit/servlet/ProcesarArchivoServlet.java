package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.app.dao.ProductoDAO;
import ar.com.app.dao.impl.ProductoDAOJdbcImpl;
import ar.com.app.domain.Producto;
import ar.com.educacionit.fileparse.FileParser;

@WebServlet(name="ProcesarArchivoServlet", urlPatterns="/api/file/upload")

public class ProcesarArchivoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombreArchivo = req.getParameter("nombreArchivo");
		
		FileParser fp = new FileParser(nombreArchivo);
		
		List<Producto> listaProductos = fp.parsearArchivo();
		
		ProductoDAO productoDao = new ProductoDAOJdbcImpl();
		
		AtomicInteger fallidos = new AtomicInteger(0);
		AtomicInteger exitos = new AtomicInteger(0);

		//ANTES DE JAVA 8
		/*for(Producto producto :listaProductos) {
			try {
				productoDao.insertar(producto);
				exitos.incrementAndGet();
			} catch (GenericException | DuplicateProductoException e) {
				fallidos.incrementAndGet();
				System.out.println("No se pudo grabar el producto leido" + producto);
			}
		}*/
		
		// FILTRAS SOLO LOS PRODUCTOS CON PRECIO MENOS A 6500
		List<Producto> menosA6500 = listaProductos.stream()
				.peek(p -> System.out.println("original" + p))
				.filter(p -> p.getPrecio() < 6500)
				.peek(p -> System.out.println("luego de filter" + p))
				.collect(Collectors.toList());
		
		
		//muestro los productos de la lista original
		System.out.println("Productos de la lista original");
		listaProductos.forEach( p -> System.out.println(p));
		
		System.out.println("Productos de la lista filtrada con precios menos a 6500");
		menosA6500.forEach( p -> System.out.println(p));
		
		//CON JAVA 8
		/*listaProductos.stream().forEach((producto) -> {
			try {
				productoDao.insertar(producto);
				exitos.incrementAndGet();
			} catch (GenericException | DuplicateProductoException e) {
				fallidos.incrementAndGet();
				System.out.println("No se pudo grabar el producto leido" + producto);
			}
		});*/
		
		//redicciono a otro jsp
		req.setAttribute("fallidos", fallidos);
		req.setAttribute("exitos", exitos);
		
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/resultado.jsp");
		
		requestDispatcher.include(req, resp);
	}
	
}
