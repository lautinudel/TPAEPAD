package isi.aepad.tp01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLocalidad;
	private String descripcion;
	
	
	public Localidad() {
	}

	public Localidad(long id, String descripcion) {
		super();
		this.idLocalidad = id;
		this.descripcion = descripcion;
	}
	
	public long getId() {
		return idLocalidad;
	}
	
	public void setId(long id) {
		this.idLocalidad = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
