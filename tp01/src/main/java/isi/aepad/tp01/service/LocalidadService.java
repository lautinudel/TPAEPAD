package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Localidad;

public interface LocalidadService {
	public Localidad buscarPorId(long id);
	
	public Localidad guardar(Localidad l);
	
	public void borrar(long id);
	
	public List<Localidad> buscarTodos();
}
