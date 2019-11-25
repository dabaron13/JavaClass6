<%@page isELIgnored="false"%>

<html>

	<head>
	
	</head>

	<body>

		<img alt="imagen copiada" src="${pageContext.request.contextPath}/${imagePath}">
		<br>
		<a href="${pageContext.request.contextPath}/jsp/binary/leerarchivo.jsp">Volver</a>
	</body>
	
</html>
<%--

<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>/resources/*</url-pattern>
</servlet-mapping>

--%>