<%@page import="ar.com.app.domain.Producto"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>

<html>
	<!-- incluye header.jsp: css y js necesarios para ver lindas las paginas -->
	<header>
		<%@include file="bootstrap/header.jsp" %>
	</header>
	
	<!-- incluye el menu: navbar.jsp -->
	<%@include file="bootstrap/navbar.jsp" %>
	<body>
		<div class="container">
			<h1>Listado de productos</h1>
			<div class="row">
				<table class="table table-striped">
				 	 <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Descripcion</th>
					      <th scope="col">Precio</th>
					    </tr>
					  </thead>
					  <tbody>
						    <%
								List<Producto> productos = (List<Producto>)request.getAttribute("productos");
								if(!productos.isEmpty()) {
									for(Producto p : productos) {
										out.print("<tr>");
											out.print("<th scope=\"row\">");
												out.print(p.getId());
											out.print("</th>");
											out.print("<th>");
												out.print(p.getDescripcion());
											out.print("</th>");
											out.print("<th>");
												out.print(p.getPrecio());
											out.print("</th>");
										out.print("</tr>");
									}
								}else{
									out.print("No hay productos");	
								}					
							%>
					  </tbody>
				</table>
			</div>
			<div class="row">
				<a href="<%=request.getContextPath()%>/index.jsp">Volver</a>
			</div>
		</div>
	</body>
</html>