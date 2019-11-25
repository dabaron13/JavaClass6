package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="PersonaServler", urlPatterns="/api")

public class PersonaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
		
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		
		Map<String, String> valores = new HashMap<>();
		valores.put("nombre", nombre);
		valores.put("apellido", apellido);
		
		req.setAttribute("valores", valores);
		
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/hello.jsp");
		
		requestDispatcher.include(req, resp);
	}
	
}
