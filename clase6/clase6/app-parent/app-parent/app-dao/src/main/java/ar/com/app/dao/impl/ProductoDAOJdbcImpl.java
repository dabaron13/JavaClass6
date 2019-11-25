package ar.com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.app.dao.ProductoDAO;
import ar.com.app.db.AdministradorDeConexiones;
import ar.com.app.domain.Producto;
import ar.com.app.exeption.CafeStoreException;
import ar.com.app.exeption.NegocioException;

public class ProductoDAOJdbcImpl implements ProductoDAO {

	private Connection con;
	
	@Override
	public Producto insert(Producto p) throws Exception {
		try {
			con = AdministradorDeConexiones.obtenerConexion();
		}catch (Exception e) {
			System.err.println("Error obteneniendo la conexion" + e.getMessage());
			throw new Exception(e.getMessage());
		}		
		
		con.setAutoCommit(false);
		
		String sql = "insert into Productos (precio, descripcion, codigo, titulo) values (?,?,?,?)";
		
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql,
			        Statement.RETURN_GENERATED_KEYS);
		}catch (Exception e) {
			System.err.println("Error creando prepared statement" + e.getMessage());
			throw new Exception(e.getMessage());
		}
			
		st.setDouble(1, p.getPrecio());
		st.setString(2, p.getDescripcion());
		st.setString(3, p.getCodigo());
		st.setString(4, p.getTitulo());
		try { 
			st.execute();
			 
			ResultSet rs = st.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			
			p.setId(new Long(generatedKey));
			
			con.commit();
		}catch (Exception e) {
			System.err.println("Error consultando a la base de datos " + e.getMessage());
		} finally {
			st.close();
			con.close();
		}			
		
		return p;
	}

	@Override
	public void delete(Long id) throws CafeStoreException, NegocioException {
		PreparedStatement st = null;
		Connection con = null;
		//controla si existe
		if (!existe(id)) {
			throw new NegocioException("El producto no existe");
		}
		
		//existe -> intenta eliminar 
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "delete from Productos where id = ?";
			st = con.prepareStatement(sql);
			st.setLong(1, id);
			st.execute();
		} catch (Exception e) {
			throw new CafeStoreException(e.getMessage());
		} finally {
			//cierro las conexiones
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new CafeStoreException(e.getMessage());
			}
		}

	}

	private boolean existe(Long id) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "select count(*) from Productos where id  = ?";
			st = con.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			existe = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return existe;
	}

	@Override
	public void update(Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Producto> selectAll() {
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			String sql = "select * from Productos";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			Producto p;
			//mientras existan datos, creo producto y agregao a la lista productos
			while (rs.next()) {
				Long id = rs.getLong("id");
				double precio = rs.getDouble("precio");
				String desc = rs.getString("descripcion");
				
				p = new Producto(id, desc, precio);
				
				productos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return productos;
	}
	
	@Override
	public Collection<Producto> findAll(Producto producto) {
			
			Collection<Producto> productos = new ArrayList<Producto>();
			
			Connection con = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			
			try {
				con = AdministradorDeConexiones.obtenerConexion();
				StringBuffer sql = new StringBuffer();
				sql.append("select * from Productos");
				
				String whereQuery = builWhereQuery(producto);
				
				String queryFinal;
				if(!whereQuery.isEmpty()) {
					sql.append(" where ").append(whereQuery);
					queryFinal = sql.substring(0, sql.length() - 4);
				}else {
					queryFinal = sql.toString();
				}
				
				st = con.prepareStatement(queryFinal);
				
				rs = st.executeQuery();
				
				Producto p;
				//mientras existan datos, creo producto y agregao a la lista productos
				while (rs.next()) {
					Long id = rs.getLong("id");
					double precio = rs.getDouble("precio");
					String desc = rs.getString("descripcion");
					String codigo = rs.getString("codigo");
					
					p = new Producto(id, desc, precio, codigo);
					
					productos.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					st.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			return productos;
	}

	private String builWhereQuery(Producto producto) {
		StringBuffer sql = new StringBuffer("");
		if(producto.getCodigo() != null && !"".equals(producto.getCodigo())) {
			sql.append("codigo = ").append(producto.getCodigo()).append(" and ");
		}
		if(producto.getDescripcion()!=null && !"".equals(producto.getDescripcion())) {
			sql.append("descripcion like ").append("'%").append(producto.getDescripcion()).append("%'").append(" and ");
		}
		if(producto.getPrecio()!=null) {
			sql.append("precio = ").append(producto.getPrecio()).append(" and ");
		}
		if(producto.getTitulo()!=null && !"".equals(producto.getTitulo())) {
			sql.append("titulo like ").append("'%").append(producto.getTitulo()).append("%'").append(" and ");
		}
		return sql.toString();
	}
}
