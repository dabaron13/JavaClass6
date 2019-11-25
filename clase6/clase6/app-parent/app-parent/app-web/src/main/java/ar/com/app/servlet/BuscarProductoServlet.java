package ar.com.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

@WebServlet(name="ProductoServler", urlPatterns="/api/buscar")
public class BuscarProductoServlet extends HttpServlet {

	private static final long serialVersionUID = -1169427142427464300L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
		
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String descripcion = req.getParameter("descripcion");
		String precio = req.getParameter("precio");
		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");

		Double precioDouble = null;
		if(precio!=null && !"".equals(precio)) {
			 precioDouble = Double.parseDouble(precio);
		}
		Producto producto = new Producto(descripcion, precioDouble);
		producto.setTitulo(titulo);
		producto.setCodigo(codigo);
		
		ProductoService ps = new ProductoServiceImpl();
		Collection<Producto>  productos;
		try {
			productos = ps.buscarProductos(producto);
		}catch (Exception e) {
			System.err.println(e.getMessage());
			productos = new ArrayList<Producto>();
		}
		
		req.setAttribute("productos", productos);
		
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/resultadoBuscar.jsp");
		
		requestDispatcher.include(req, resp);
	}
	
}
