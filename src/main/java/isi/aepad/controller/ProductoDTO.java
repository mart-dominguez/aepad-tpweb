package isi.aepad.controller;

public class ProductoDTO {

	private Integer id;
	private String descripcion;
	private Double precio;
	
	 
	
	public ProductoDTO() {
		super();
	}
	public ProductoDTO(String descripcion, Double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public ProductoDTO(Integer id, String descripcion, Double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "ProductoDTO [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductoDTO other = (ProductoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
