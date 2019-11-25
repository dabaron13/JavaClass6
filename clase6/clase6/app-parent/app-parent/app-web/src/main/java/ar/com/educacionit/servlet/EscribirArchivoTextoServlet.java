package ar.com.educacionit.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="EscribirArchivoServlet", urlPatterns="/api/file/text/write")

/**
 * Escritura de un Archivo de Texto + (jso + Servlet)
 *
 */
public class EscribirArchivoTextoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombreArchivo = req.getParameter("nombreArchivo");

		System.out.println("Nombre arhivo: " + nombreArchivo);
		
		// Define la información a guardar en el archivo
		String contenidoArchivo = req.getParameter("textoArchivo");
		
		System.out.println("Contenido archivo:  " + contenidoArchivo);
		
		String filePath = getServletContext().getRealPath(System.getProperty("file.separator") + "file" + System.getProperty("file.separator") +  "text" + System.getProperty("file.separator") + nombreArchivo);
		
		System.out.println("Ubicacion del archivo destino:  " + filePath);
		
		// Define el archivo a utilizar
		File archivoSalida = new File(filePath);
	
		// Abre el stream necesario
		FileWriter out = new FileWriter(archivoSalida);
		
		// Escribe el archivo con la información
		System.out.print("Grabando en el archivo: ");
		for(int i=0; i<contenidoArchivo.length(); i++) {
			char contenido = contenidoArchivo.charAt(i);
			System.out.print(contenido);
			out.write( contenido );
		}
		
		System.out.println("");
		
		// Cierra los streams
		out.close();

		System.out.println("Stream de escritura cerrado");
		
		req.setAttribute("archivoEscrito", new Boolean(true));
		
		//redireccionar a una jsp
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/jsp/text/escribir.jsp");
		
		requestDispatcher.forward(req, resp);
	}
	
}
