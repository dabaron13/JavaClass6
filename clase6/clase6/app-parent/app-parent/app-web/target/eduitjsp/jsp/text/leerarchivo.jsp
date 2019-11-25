<%@page isELIgnored="false"%>
<html>
	<body>
		<h2>Lectura de un Archivo de Texto</h2>
	
		<form action="${pageContext.request.contextPath}/api/file/text/read" method="POST"/>
			<input type="submit" value="Leer Archivo"/>
		</form>
	</body>
	
	<% 
		if(request.getAttribute("archivoLeido") != null) {
	%>		
		<p>Se ha leido el archivo exitosamente</p>
		<a href="${pageContext.request.contextPath}/jsp/text/leerarchivo.jsp"/>Volver</a>
	<%
		}
	%>
	
</html>
