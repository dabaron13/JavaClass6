package ar.com.app.domain;

public class Producto implements Comparable<Producto> {

	private Long id;
	private String descripcion;
	private Double precio;
	private String codigo;
	private String titulo;
	
	public Producto(String descripcion, Double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public Producto(Long id2, String desc, double precio2) {
		this.descripcion = desc;
		this.precio = precio2;
		this.id = id2;
	}
	public Producto(Long id2, String desc, double precio2, String codigo2) {
		this.descripcion = desc;
		this.precio = precio2;
		this.id = id2;
		this.codigo = codigo2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Producto other = (Producto) obj;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!other.precio.equals(precio))
			return false;
		return true;
	}
	@Override
	public int compareTo(Producto o) {
		//return o.getPrecio().compareTo(this.precio);
		return this.precio.compareTo(o.getPrecio());
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;		
	}
	public String getCodigo() {
		return codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
