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
			<div class="row">
				<div class="col-xs-12 col-md-12 col-lg-12">
					<h1>Alta de producto</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-md-12 col-lg-12">
					<form action="${pageContext.request.contextPath}/api/alta" method="POST">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Titulo:</label>
					    <input type="text" name="titulo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
					    <small id="emailHelp" class="form-text text-muted">titulo del producto</small>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Descripcion</label>
					    <input type="text" name="descripcion" class="form-control" id="exampleInputPassword1" placeholder="Password">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPrecio1">Precio</label>
					    <input type="text" name="precio" class="form-control" id="exampleInputPrecio1" placeholder="Precio">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputCodigo1">Codigo</label>
					    <input type="text" name="codigo" class="form-control" id="exampleInputCodigo1" placeholder="Codigo">
					  </div>
					  <button type="submit" class="btn btn-primary">Grabar</button>
					</form>
				</div>
			</div>	
		</div>	
	
	</body>
</html>
