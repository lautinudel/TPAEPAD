package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Producto;
import isi.aepad.tp01.repository.ProductoRepository;
import isi.aepad.tp01.service.ProductoService;

@Service
public class ProductoServiceDefault implements ProductoService{

	@Autowired
	ProductoRepository productoRepo;
	
	@Override
	public Producto buscarPorId(long id) {
		return productoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con ID "+id));
	}

	@Override
	public Producto guardar(Producto p) {
		return productoRepo.save(p);
	}

	@Override
	public void borrar(long id) {
		productoRepo.deleteById(id);
		
	}

	@Override
	public List<Producto> buscarTodos() {
		return productoRepo.findAll();
	}

}
