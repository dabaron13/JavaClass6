package ar.com.app.servlet;

import java.io.IOException;

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

@WebServlet(name = "AltaProductoServlet", urlPatterns = "/api/alta")
public class AltaProductoServlet extends HttpServlet {

	private static final long serialVersionUID = -3128311198379036156L;
	
	private ProductoService ps = new ProductoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// OBTIENE LOS PARAMETROS DESDE LA JSP
		String descripcion = req.getParameter("descripcion");
		String precio = req.getParameter("precio");
		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");

		try {
			//INSTANCIO UN PRODUCTO PARA GRABAR
			Producto nuevoProducto = new Producto(descripcion, Double.parseDouble(precio));
			nuevoProducto.setTitulo(titulo);
			nuevoProducto.setCodigo(codigo);

			//LLAMO AL SERVICIO PARA CREAR EL PRODUCTO NUEVO
			Producto producto = ps.crearProducto(nuevoProducto);
			
			//GUARDO EN REQUEST UN MENASJE CON ID DEL PRODUCTO CREADO
			req.setAttribute("resultadoAlta", "Alta exitosa id=" + producto.getId());
		} catch (Exception e) {
			//INFORMO EL ERROR SI NO HA PODIDO GRABAR EL PRODUCTO  
			System.err.println(e.getMessage());
			req.setAttribute("resultadoAlta", "Alta fallida");
		}

		ServletContext servletContext = getServletContext();

		//REDIRECCIONO A UNA NUEVA JSP
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/resultadoAlta.jsp");

		requestDispatcher.include(req, resp);
	}

}
