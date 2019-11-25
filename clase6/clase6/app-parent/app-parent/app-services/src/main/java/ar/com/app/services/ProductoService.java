package ar.com.app.services;

import java.util.Collection;

import ar.com.app.domain.Producto;

public interface ProductoService {
	
	public Producto crearProducto(Producto p) throws Exception;

	public void eliminarProducto(Long id) throws Exception;

	public Collection<Producto> obtenerTodos() throws Exception;;

	public Collection<Producto> buscarProductos(Producto producto) throws Exception;;
}
