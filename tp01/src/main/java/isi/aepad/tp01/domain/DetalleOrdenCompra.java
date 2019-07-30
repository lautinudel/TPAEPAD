package isi.aepad.tp01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DetalleOrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetalleOrdenCompra;
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "idOrdenCompra")
	private OrdenCompra ordenCompra;
	private int cantidad;
	private double precio;
	private double total;
	
	
	public DetalleOrdenCompra() {
	}

	public DetalleOrdenCompra(Producto producto, int cantidad, double precio, double total) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
	}
	
	
	
	public DetalleOrdenCompra(long idDetalleOrdenCompra, Producto producto, OrdenCompra ordenCompra, int cantidad,
			double precio, double total) {
		super();
		this.idDetalleOrdenCompra = idDetalleOrdenCompra;
		this.producto = producto;
		this.ordenCompra = ordenCompra;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
	}

	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public long getIdDetalleOrdenCompra() {
		return idDetalleOrdenCompra;
	}

	public void setIdDetalleOrdenCompra(long idDetalleOrdenCompra) {
		this.idDetalleOrdenCompra = idDetalleOrdenCompra;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}	
	
}
