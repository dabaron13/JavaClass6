package ar.com.app.services.impl;

import java.util.Collection;

import ar.com.app.dao.ProductoDAO;
import ar.com.app.dao.impl.ProductoDAOJdbcImpl;
import ar.com.app.domain.Producto;
import ar.com.app.services.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO pd;
	
	public ProductoServiceImpl() {
		this.pd = new ProductoDAOJdbcImpl();
	}
	
	@Override
	public Producto crearProducto(Producto p) throws Exception {
		return pd.insert(p);
	}

	@Override
	public void eliminarProducto(Long id) throws Exception {
		pd.delete(id);
	}

	@Override
	public Collection<Producto> obtenerTodos() {
		return pd.selectAll();
	}

	@Override
	public Collection<Producto> buscarProductos(Producto producto) throws Exception {
		return pd.findAll(producto);
	}

}
