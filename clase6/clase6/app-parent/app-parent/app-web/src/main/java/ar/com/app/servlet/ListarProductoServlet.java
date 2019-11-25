package ar.com.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.app.domain.Producto;
import ar.com.app.services.ProductoService;
import ar.com.app.services.impl.ProductoServiceImpl;

@WebServlet(name="ListarProductoServlet", urlPatterns="/api/listar")
public class ListarProductoServlet extends HttpServlet {

	private static final long serialVersionUID = -1169427142427464300L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductoService ps = new ProductoServiceImpl();
		
		Collection<Producto> productos;
		try {
			productos = ps.obtenerTodos();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			productos = new ArrayList<Producto>();
		}
		
		List<Double> precios = productos.stream()
		.map(p -> p.getPrecio())
		.collect(Collectors.toList());
		
		Double precioToal = precios.stream()
				.reduce(0d,(precio1, precio2) -> precio1+ precio2);
		
		System.out.println(precioToal);
		
		Double totalPrecio = productos.stream()
		.map(p -> p.getPrecio())
		.reduce(0D,(precio1, precio2) -> precio1+ precio2);
		
		System.out.println(totalPrecio);
		  
		
		req.setAttribute("productos", productos);
		
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/resultadoBuscar.jsp");
		
		requestDispatcher.include(req, resp);
	}
}
