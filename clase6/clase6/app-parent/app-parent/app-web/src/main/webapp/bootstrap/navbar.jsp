<div class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="<%=request.getContextPath()%>">APP HOME</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="<%=request.getContextPath()%>/alta.jsp">Alta Producto</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<%=request.getContextPath()%>/buscar.jsp">Buscar Productos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<%=request.getContextPath()%>/api/listar?clave=valr">Listar Productos</a>
      	</li>
		<li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Archivos
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="<%=request.getContextPath()%>/jsp/text/leerarchivo.jsp">Leer archivo texto</a>
	          <a class="dropdown-item" href="#">Leer archivo binario</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">Copiar archivo binario</a>
	        </div>
	      </li>	      
    </ul>
	    <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/api/buscar" method="POST">
	      <input name="titulo" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
	    </form>
	  </div>
	</nav>
</div>