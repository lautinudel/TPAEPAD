package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Pago;

public interface PagoService {
	
	public Pago buscarPorId(long id);
	
	public Pago guardar(Pago c);
	
	public void borrar(long id);
	
	public List<Pago> buscarTodos();
}
