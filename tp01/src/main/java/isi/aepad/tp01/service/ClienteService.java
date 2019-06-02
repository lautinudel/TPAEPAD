package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Cliente;

public interface ClienteService {
	
	public Cliente buscarPorId(long id);
	
	public Cliente guardar(Cliente c);
	
	public void borrar(long id);
	
	public List<Cliente> buscarTodos();
}
