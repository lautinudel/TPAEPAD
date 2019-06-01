package isi.aepad.tp01.domain;

public class Producto {
	private int id;
	private String descripcion;
	private Double precio;
	private int stock;
	public int getId() {
		return id;
	}
	
	
	public Producto(int id, String descripcion, Double precio, int stock) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}


	public void setId(int id) {
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
