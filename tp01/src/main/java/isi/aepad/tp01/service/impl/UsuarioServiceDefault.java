package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Usuario;
import isi.aepad.tp01.repository.UsuarioRepository;
import isi.aepad.tp01.service.UsuarioService;

@Service
public class UsuarioServiceDefault implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Override
	public Usuario buscarPorId(String username) {
		return usuarioRepo.findById(username).orElseThrow(() -> new RuntimeException("No se encontro el usuario con ID "+username));
	}

	@Override
	public Usuario guardar(Usuario u) {
		return usuarioRepo.save(u);
	}

	@Override
	public void borrar(String username) {
		usuarioRepo.deleteById(username);
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuarioRepo.findAll();
	}

}
