package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Producto;

public interface ProductoService {
	public Producto buscarPorId(long id);
	
	public Producto guardar(Producto p);
	
	public void borrar(long id);
	
	public List<Producto> buscarTodos();
}
