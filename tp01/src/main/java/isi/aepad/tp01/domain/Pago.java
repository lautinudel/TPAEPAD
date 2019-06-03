package isi.aepad.tp01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPago;
	@OneToOne
	private MedioDePago medioPago;
	private double monto;
	@OneToOne
	private Cliente cliente;
	@OneToOne
	private Pedido pedido;
	//private boolean pagoRelizdo;
	
	public Pago(MedioDePago medioPago, double monto, Cliente cliente) {
		super();
		this.medioPago = medioPago;
		this.monto = monto;
		this.cliente = cliente;
	}

	public MedioDePago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioDePago medioPago) {
		this.medioPago = medioPago;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public long getIdPago() {
		return idPago;
	}

	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	
}
