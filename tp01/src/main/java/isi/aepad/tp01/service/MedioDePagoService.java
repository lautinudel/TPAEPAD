package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.MedioDePago;

public interface MedioDePagoService {
	public MedioDePago buscarPorId(long id);
	
	public MedioDePago guardar(MedioDePago m);
	
	public void borrar(long id);
	
	public List<MedioDePago> buscarTodos();
}
