package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Pago;
import isi.aepad.tp01.repository.PagoRepository;
import isi.aepad.tp01.service.PagoService;
@Service
public class PagoServiceDefault implements PagoService {
	
	@Autowired
	PagoRepository pagoRepo;
		
	@Override
	public Pago buscarPorId(long id) {
		return pagoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el pago con ID "+id));
	}

	@Override
	public Pago guardar(Pago p) {
		return pagoRepo.save(p);
	}

	@Override
	public void borrar(long id) {
		pagoRepo.deleteById(id);
		
	}

	@Override
	public List<Pago> buscarTodos() {
		return pagoRepo.findAll();
	}
}
