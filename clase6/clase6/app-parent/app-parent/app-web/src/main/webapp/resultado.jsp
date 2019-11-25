<%@page isELIgnored="false"%>

<html>

	<head>
	
	</head>

	<body>
		<p>Se ha procesado el archivo</p>
		<p>Con ${exitos} procesados exitosamente</p>
		<p>Con <%=request.getAttribute("fallidos")%> procesados fallidos</p>
	</body>
	
</html>