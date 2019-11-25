<%@page isELIgnored="false"%>
<html>
	<body>
		<h2>Lectura de un Archivo de Binario	</h2>
	
		<form action="${pageContext.request.contextPath}/api/file/binary/read" method="POST"/>
			<input type="submit" value="Copiar Archivo Binario"/>
		</form>
	</body>
	
	<% 
		if(request.getAttribute("archivoLeido") != null) {
	%>		
		<p>Se ha leido el archivo binrio exitosamente</p>
		<a href="${pageContext.request.contextPath}/jsp/binary/leerarchivo.jsp"/>Volver</a>
	<%
		}
	%>
	
</html>
