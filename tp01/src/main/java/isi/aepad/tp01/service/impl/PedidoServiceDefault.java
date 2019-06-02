package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Pedido;
import isi.aepad.tp01.repository.PedidoRepository;
import isi.aepad.tp01.service.PedidoService;

@Service
public class PedidoServiceDefault implements PedidoService{
	
	@Autowired
	PedidoRepository pedidoRepo;
	
	@Override
	public Pedido buscarPorId(long id) {
		return pedidoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el pedido con ID "+id));	}

	@Override
	public Pedido guardar(Pedido p) {
		return pedidoRepo.save(p);
	}

	@Override
	public void borrar(long id) {
		pedidoRepo.deleteById(id);
		
	}

	@Override
	public List<Pedido> buscarTodos() {
		return pedidoRepo.findAll();
	}

}
