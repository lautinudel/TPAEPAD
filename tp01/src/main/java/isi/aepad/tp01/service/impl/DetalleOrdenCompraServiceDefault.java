package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import isi.aepad.tp01.domain.DetalleOrdenCompra;
import isi.aepad.tp01.repository.DetalleOrdenCompraRepository;
import isi.aepad.tp01.service.DetalleOrdenCompraService;

public class DetalleOrdenCompraServiceDefault implements DetalleOrdenCompraService {

	@Autowired
	DetalleOrdenCompraRepository detalleOrdenCompraRepo;
	
	@Override
	public DetalleOrdenCompra buscarPorId(long id) {
		return detalleOrdenCompraRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la detalle de orden de compra con ID "+id));
	}

	@Override
	public DetalleOrdenCompra guardar(DetalleOrdenCompra l) {
		return detalleOrdenCompraRepo.save(l);
	}

	@Override
	public void borrar(long id) {
		detalleOrdenCompraRepo.deleteById(id);
		
	}

	@Override
	public List<DetalleOrdenCompra> buscarTodos() {
		return detalleOrdenCompraRepo.findAll();
	}
}
