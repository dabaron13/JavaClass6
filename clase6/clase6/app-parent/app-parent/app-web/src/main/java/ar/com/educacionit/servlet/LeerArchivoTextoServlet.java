package ar.com.educacionit.servlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LeerArchivoTextoServlet", urlPatterns="/api/file/text/read")

/**
 * Lectura de un Archivo de Texto (jsp + servlet)
 *
 */
public class LeerArchivoTextoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String filePath = getServletContext().getRealPath("/jsp/text/entrada.txt");
		
		System.out.println("Ubicacion de arhivo a leer: " + filePath);
		
		File inputFile = new File(filePath);		
		
		FileReader fr = new FileReader(inputFile);

		int unCaracter;
		
		System.out.println("Leyendo arhivo:");
		while((unCaracter = fr.read()) != -1) {
			System.out.println((char)unCaracter);
		}
		
		fr.close();

		req.setAttribute("archivoLeido", new Boolean(true));
		
		System.out.println("Arhivo Leido:");
		
		//redireccionar a una jsp
		ServletContext servletContext = getServletContext();
		
		String targetPath = "/jsp/text/leerarchivo.jsp";
		
		System.out.println("Redireccionando a: " + targetPath);
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(targetPath);
		
		requestDispatcher.forward(req, resp);
	}
	
}
