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
	
	
}
