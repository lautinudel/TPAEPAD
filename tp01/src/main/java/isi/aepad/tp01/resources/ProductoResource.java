package isi.aepad.tp01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isi.aepad.tp01.domain.Producto;
import isi.aepad.tp01.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoResource {
	@Autowired
	private ProductoService productoService;

	@GetMapping("producto")
	public ResponseEntity<List<Producto>> buscar() {
		return  new ResponseEntity<List<Producto>>(this.productoService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("producto/{idProducto}")
	public ResponseEntity<Producto> buscar(@PathVariable(required=false) long idProducto) {
		return  new ResponseEntity<Producto>(this.productoService.buscarPorId(idProducto), HttpStatus.OK);
	}
	
	@PostMapping("producto")
	public ResponseEntity<Producto> crear(@RequestBody Producto p,UriComponentsBuilder builder) {
		Producto creado = this.productoService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Producto>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("producto")
	public ResponseEntity<Producto> actualizar(@RequestBody Producto p,UriComponentsBuilder builder) {
		Producto actualizar = this.productoService.guardar(p);
        return new ResponseEntity<Producto>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("producto/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idProducto) {
        this.productoService.borrar(idProducto);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
