package isi.aepad.tp01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetallePedido;
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	private int cantidad;
	private double precio;
	private double total;
	@ManyToOne
	@JoinColumn(name="idPedido")
	private Pedido pedido;
	
	
	public DetallePedido() {
	}

	public DetallePedido(Producto producto, int cantidad, double precio, double total) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
	}
	
	
	public DetallePedido(long idDetallePedido, Producto producto, int cantidad, double precio, double total,
			Pedido pedido) {
		super();
		this.idDetallePedido = idDetallePedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.pedido = pedido;
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

	public long getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(long idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
