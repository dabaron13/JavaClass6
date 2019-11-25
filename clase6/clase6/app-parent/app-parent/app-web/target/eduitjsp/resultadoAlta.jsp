<%@page isELIgnored="false"%>
<html>
	<body>
		<h2>Alta de Producto</h2>
		<form action="${pageContext.request.contextPath}/index.jsp">
			<table>
				<tr>
					<td>
						Resultado Alta: <%=request.getAttribute("resultadoAlta") %>
					</td>
				</tr>				
				<tr>
					<td colspan="2">
						<input type="submit" value="Volver"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
