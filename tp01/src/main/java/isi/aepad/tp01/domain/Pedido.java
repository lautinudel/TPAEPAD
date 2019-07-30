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
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	private long numeroPedido;
	private Date fechaPedido;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@OneToMany(targetEntity=DetallePedido.class, mappedBy="pedido")
	@JsonIgnore
	private List<DetallePedido> detallePedido;
	
	public Pedido(long id, long numeroPedido, Date fecha, Cliente cliente, List<DetallePedido> detallePedido) {
		super();
		this.idPedido = id;
		this.numeroPedido = numeroPedido;
		this.fechaPedido = fecha;
		this.cliente = cliente;
		this.detallePedido = detallePedido;
	}

	public long getId() {
		return idPedido;
	}

	public void setId(long id) {
		this.idPedido = id;
	}

	public long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Date getFecha() {
		return fechaPedido;
	}

	public void setFecha(Date fecha) {
		this.fechaPedido = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}	
	
}
