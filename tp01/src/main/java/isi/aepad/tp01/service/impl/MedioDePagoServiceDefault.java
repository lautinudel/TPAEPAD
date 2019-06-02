package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.MedioDePago;
import isi.aepad.tp01.repository.MedioDePagoRepository;
import isi.aepad.tp01.service.MedioDePagoService;

@Service
public class MedioDePagoServiceDefault implements MedioDePagoService{

	@Autowired
	MedioDePagoRepository medioDePagoRepo;
	
	@Override
	public MedioDePago buscarPorId(long id) {
		return medioDePagoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el medio de pago con ID "+id));
	}

	@Override
	public MedioDePago guardar(MedioDePago m) {
		return medioDePagoRepo.save(m);
	}

	@Override
	public void borrar(long id) {
		medioDePagoRepo.deleteById(id);
		
	}

	@Override
	public List<MedioDePago> buscarTodos() {
		return medioDePagoRepo.findAll();
	}

}
