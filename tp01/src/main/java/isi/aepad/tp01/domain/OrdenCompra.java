package isi.aepad.tp01.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrdenCompra;
	private long numeroOrdenCompra;
	private Date fechaOrdenCompra;
	@OneToOne
	private Cliente cliente;
	@OneToOne
	private DetalleOrdenCompra detalleOrdenCompra;
	
	
	public OrdenCompra(long idOrdenCompra, long numeroOrdenCompra, Date fechaOrdenCompra, Cliente cliente,
			DetalleOrdenCompra detalleOrdenCompra) {
		super();
		this.idOrdenCompra = idOrdenCompra;
		this.numeroOrdenCompra = numeroOrdenCompra;
		this.fechaOrdenCompra = fechaOrdenCompra;
		this.cliente = cliente;
		this.detalleOrdenCompra = detalleOrdenCompra;
	}

	public long getIdOrdenCompra() {
		return idOrdenCompra;
	}

	public void setIdOrdenCompra(long idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}

	public long getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(long numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public Date getFechaOrdenCompra() {
		return fechaOrdenCompra;
	}

	public void setFechaOrdenCompra(Date fechaOrdenCompra) {
		this.fechaOrdenCompra = fechaOrdenCompra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DetalleOrdenCompra getDetallePedido() {
		return detalleOrdenCompra;
	}


	public void setDetallePedido(DetalleOrdenCompra detallePedido) {
		this.detalleOrdenCompra = detallePedido;
	}	
}
