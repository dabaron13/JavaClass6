<%@page isELIgnored="false"%>
<html>
	<body>
		<h2>Escribir archivos texto</h2>
	
		<form action="${pageContext.request.contextPath}/api/file/text/write" method="POST"/>
			<p>Nombre Archivo:</p> 
			<input type="text" name="nombreArchivo"><br>
			<p>Contenido:</p> 
			<textarea name="textoArchivo" maxlength="1000" rows="5"></textarea>
			<hr>
			<input type="submit" value="Enviar"/>
		</form>		
		<% 
			if(request.getAttribute("archivoEscrito") != null) {
		%>		
			<p>Se ha grabado el archivo exitosamente</p>
			<a href="${pageContext.request.contextPath}/jsp/text/escribir.jsp"/>Volver</a>
		<%
			}
		%>
	</body>
</html>
