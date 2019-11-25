<%@page isELIgnored="false"%>
<html>
	<body>
		<h1>PROCEAR ARCHIVO DE PRODUCTOS</h1>
	
		<form action="${pageContext.request.contextPath}/api/file/upload" method="POST"/>
			Nombre archivo: <br>
			<input type="text" name="nombreArchivo">
			<input type="submit" value="Procesar Archivo"/>
		</form>
		
	</body>
</html>
