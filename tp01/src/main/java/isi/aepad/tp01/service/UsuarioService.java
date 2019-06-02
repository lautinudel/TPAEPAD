package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Usuario;

public interface UsuarioService {
	public Usuario buscarPorId(String username);
	
	public Usuario guardar(Usuario u);
	
	public void borrar(String username);
	
	public List<Usuario> buscarTodos();
}
