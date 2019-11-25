package ar.com.app.dao;

import java.util.Collection;

import ar.com.app.domain.Producto;
import ar.com.app.exeption.CafeStoreException;
import ar.com.app.exeption.NegocioException;

public interface ProductoDAO {
	
	public void delete(Long id) throws CafeStoreException, NegocioException;
	
	public void update(Producto p);

	public Collection<Producto> selectAll();

	public Producto insert(Producto producto) throws Exception;
	
	public Collection<Producto> findAll(Producto producto);
}

