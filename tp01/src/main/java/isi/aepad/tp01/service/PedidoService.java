package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Pedido;

public interface PedidoService {
	public Pedido buscarPorId(long id);
	
	public Pedido guardar(Pedido p);
	
	public void borrar(long id);
	
	public List<Pedido> buscarTodos();
}
