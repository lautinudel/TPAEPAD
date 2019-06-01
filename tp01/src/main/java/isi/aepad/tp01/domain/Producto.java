package isi.aepad.tp01.domain;

public class Producto {
	private long idProducto;
	private String descripcion;
	private Double precio;
	private int stock;
	
	
	
	public Producto(int id, String descripcion, Double precio, int stock) {
		super();
		this.idProducto = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	public long getId() {
		return idProducto;
	}

	public void setId(long id) {
		this.idProducto = id;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
