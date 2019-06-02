package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Cliente;
import isi.aepad.tp01.repository.ClienteRepository;
import isi.aepad.tp01.service.ClienteService;

@Service
public class ClienteServiceDefault implements ClienteService{

	@Autowired
	ClienteRepository clienteRepo;
	
	@Override
	public Cliente buscarPorId(long id) {
		return clienteRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
	}

	@Override
	public Cliente guardar(Cliente c) {
		return clienteRepo.save(c);
	}

	@Override
	public void borrar(long id) {
		clienteRepo.deleteById(id);	
	}

	@Override
	public List<Cliente> buscarTodos() {
		return clienteRepo.findAll();
	}

}
