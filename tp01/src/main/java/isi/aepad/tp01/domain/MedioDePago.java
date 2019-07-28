package isi.aepad.tp01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedioDePago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedioPago;
	private String descripcion;
	
	
	public MedioDePago() {
	}

	public MedioDePago(long id, String descripcion) {
		super();
		this.idMedioPago = id;
		this.descripcion = descripcion;
	}
	
	public long getId() {
		return idMedioPago;
	}
	
	public void setId(long id) {
		this.idMedioPago = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
}
