package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import isi.aepad.tp01.domain.DetallePedido;
import isi.aepad.tp01.repository.DetallePedidoRepository;
import isi.aepad.tp01.service.DetallePedidoService;

public class DetallePedidoServiceDefault implements DetallePedidoService{

	@Autowired
	DetallePedidoRepository detallePedidoRepo;
	
	@Override
	public DetallePedido buscarPorId(long id) {
		return detallePedidoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la detalle del pedido con ID "+id));
	}

	@Override
	public DetallePedido guardar(DetallePedido l) {
		return detallePedidoRepo.save(l);
	}

	@Override
	public void borrar(long id) {
		detallePedidoRepo.deleteById(id);
		
	}

	@Override
	public List<DetallePedido> buscarTodos() {
		return detallePedidoRepo.findAll();
	}

}
