package isi.aepad.tp01.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrdenCompra;
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long numeroOrdenCompra;
	private Date fechaOrdenCompra;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@OneToMany(targetEntity=DetalleOrdenCompra.class, mappedBy="ordenCompra")
	@JsonIgnore
	private List<DetalleOrdenCompra> detalleOrdenCompra;
	
	
	
	public OrdenCompra() {
	}

	public OrdenCompra(long idOrdenCompra, long numeroOrdenCompra, Date fechaOrdenCompra, /*Cliente cliente,*/
			List<DetalleOrdenCompra> detalleOrdenCompra) {
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
	
	public List<DetalleOrdenCompra> getDetallePedido() {
		return detalleOrdenCompra;
	}


	public void setDetallePedido(List<DetalleOrdenCompra> detallePedido) {
		this.detalleOrdenCompra = detallePedido;
	}	
}
