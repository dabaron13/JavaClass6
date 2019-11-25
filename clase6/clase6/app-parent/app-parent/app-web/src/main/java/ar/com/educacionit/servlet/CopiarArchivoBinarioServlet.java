package ar.com.educacionit.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LeerArchivoBinarioServlet", urlPatterns="/api/file/binary/read")

public class CopiarArchivoBinarioServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String filePath = getServletContext().getRealPath("pingui.jpeg");		

		File archivoEntrada = new File(filePath);
		
		String fileTargetPath = getServletContext().getRealPath("pingui.png");
		
		File archivoSalida = new File(fileTargetPath);
		
		// Abre los streams necesarios
		FileInputStream in = new FileInputStream(archivoEntrada);
		
		FileOutputStream out = new FileOutputStream(archivoSalida);
		
		int unCaracter;
		
		// Copia el archivo fuente en el archivo destino
		while ( (unCaracter = in.read()) != -1) {
			out.write(unCaracter);
		}
		// Cierra los streams
		
		in.close();

		out.close();

		req.setAttribute("imagePath", "pingui.jpeg");
		
		//redireccionar a una jsp
		ServletContext servletContext = getServletContext();
		
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/jsp/binary/resultado.jsp");
		
		requestDispatcher.include(req, resp);
	}
	
}
