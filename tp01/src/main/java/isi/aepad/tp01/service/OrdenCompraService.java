package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.OrdenCompra;

public interface OrdenCompraService {
	public OrdenCompra buscarPorId(long id);
	
	public OrdenCompra guardar(OrdenCompra o);
	
	public void borrar(long id);
	
	public List<OrdenCompra> buscarTodos();
}
