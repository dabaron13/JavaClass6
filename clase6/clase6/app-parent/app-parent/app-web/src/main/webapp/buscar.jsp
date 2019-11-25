<%@page isELIgnored="false"%>
<html>
	<body>
		<h2>Buscador de productos</h2>
		<form action="${pageContext.request.contextPath}/api/buscar" method="POST">
			<table>
				<tr>
					<td>
						Titulo:
					</td>
					<td>
						 <input type="text" name="titulo">
					</td>
				</tr>
				<tr>
					<td>
						Descripcion:
					</td>
					<td>
						 <input type="text" name="descripcion">
					</td>
				</tr>
				<tr>
					<td>
						Precio:
					</td>
					<td>
						 <input type="text" name="precio">
					</td>
				</tr>
				<tr>
					<td>
						Codigo:
					</td>
					<td>
						 <input type="text" name="codigo">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Buscar"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
