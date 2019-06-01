package isi.aepad.tp01.domain;

public class Localidad {
	private long idLocalidad;
	private String descripcion;
	
	
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
