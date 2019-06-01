package isi.aepad.tp01.domain;

public class MedioDePago {
	private long idMedioPago;
	private String descripcion;
	
	
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
