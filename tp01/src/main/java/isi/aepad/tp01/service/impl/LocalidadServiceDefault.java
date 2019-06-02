package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Localidad;
import isi.aepad.tp01.repository.LocalidadRepository;
import isi.aepad.tp01.service.LocalidadService;

@Service
public class LocalidadServiceDefault implements LocalidadService{

	@Autowired
	LocalidadRepository localidadRepo;
	
	@Override
	public Localidad buscarPorId(long id) {
		return localidadRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la localidad con ID "+id));
	}

	@Override
	public Localidad guardar(Localidad l) {
		return localidadRepo.save(l);
	}

	@Override
	public void borrar(long id) {
		localidadRepo.deleteById(id);
		
	}

	@Override
	public List<Localidad> buscarTodos() {
		return localidadRepo.findAll();
	}

}
