package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.DetalleOrdenCompra;

public interface DetalleOrdenCompraService {
	public DetalleOrdenCompra buscarPorId(long id);
	
	public DetalleOrdenCompra guardar(DetalleOrdenCompra d);
	
	public void borrar(long id);
	
	public List<DetalleOrdenCompra> buscarTodos();
}
