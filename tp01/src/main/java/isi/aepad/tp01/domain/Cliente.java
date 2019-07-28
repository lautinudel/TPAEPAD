package isi.aepad.tp01.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	private String nombre;
	private String localidad;
	@OneToMany(targetEntity=Pedido.class, mappedBy="cliente")
	@JsonIgnore
	private List<Pedido> pedidosRealizados ;
	@OneToOne
	private MedioDePago medioDePago;
	@OneToMany(targetEntity=Pago.class, mappedBy="cliente")
	@JsonIgnore
	private List<Pago> pagosRealizados;
	private int puntosAcumulados;
	
	public Cliente() {
		
	}
		
	public Cliente(long idCliente, String nombre, String localidad, List<Pedido> pedidosRealizados,
			MedioDePago medioDePago,List<Pago> pagosRealizados, int puntosAcumulados) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.localidad = localidad;
		this.pedidosRealizados = pedidosRealizados;
		this.medioDePago = medioDePago;
		this. pagosRealizados = pagosRealizados;
		this.puntosAcumulados = puntosAcumulados;
	}

	public long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public List<Pedido> getPedidosRealizados() {
		return pedidosRealizados;
	}
	
	public void setPedidosRealizados(List<Pedido> pedidosRealizados) {
		this.pedidosRealizados = pedidosRealizados;
	}
	
	public MedioDePago getMedioDePago() {
		return medioDePago;
	}
	
	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}
	
	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}
	
	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}
	
	
}
