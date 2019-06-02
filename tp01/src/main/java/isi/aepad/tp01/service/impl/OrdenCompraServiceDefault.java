package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.OrdenCompra;
import isi.aepad.tp01.repository.OrdenCompraRepository;
import isi.aepad.tp01.service.OrdenCompraService;

@Service
public class OrdenCompraServiceDefault implements OrdenCompraService {
		
	@Autowired
	OrdenCompraRepository ordenCompraRepo;
	
	@Override
	public OrdenCompra buscarPorId(long id) {
		return ordenCompraRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la orden de compra con ID "+id));
	}

	@Override
	public OrdenCompra guardar(OrdenCompra o) {
		return ordenCompraRepo.save(o);
	}

	@Override
	public void borrar(long id) {
		ordenCompraRepo.deleteById(id);
		
	}

	@Override
	public List<OrdenCompra> buscarTodos() {
		return ordenCompraRepo.findAll();
	}

}
