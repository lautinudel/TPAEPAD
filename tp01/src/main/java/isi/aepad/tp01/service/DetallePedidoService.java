package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.DetallePedido;

public interface DetallePedidoService {
	public DetallePedido buscarPorId(long id);
	
	public DetallePedido guardar(DetallePedido c);
	
	public void borrar(long id);
	
	public List<DetallePedido> buscarTodos();
}
