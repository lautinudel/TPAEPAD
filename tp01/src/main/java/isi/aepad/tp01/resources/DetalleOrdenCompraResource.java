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

import isi.aepad.tp01.domain.DetalleOrdenCompra;
import isi.aepad.tp01.service.DetalleOrdenCompraService;

@RestController
@RequestMapping("/api")
public class DetalleOrdenCompraResource {
	@Autowired
	private DetalleOrdenCompraService detalleOrdenCompraService;	

	@GetMapping("detalleOrdenCompra")
	public ResponseEntity<List<DetalleOrdenCompra>> buscar() {
		return  new ResponseEntity<List<DetalleOrdenCompra>>(this.detalleOrdenCompraService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("detalleOrdenCompra/{idDetalleOrdenCompra}")
	public ResponseEntity<DetalleOrdenCompra> buscar(@PathVariable(required=false) long idDetalleOrdenCompra) {
		return  new ResponseEntity<DetalleOrdenCompra>(this.detalleOrdenCompraService.buscarPorId(idDetalleOrdenCompra), HttpStatus.OK);
	}
	
	@PostMapping("detalleOrdenCompra")
	public ResponseEntity<DetalleOrdenCompra> crear(@RequestBody DetalleOrdenCompra d,UriComponentsBuilder builder) {
		DetalleOrdenCompra creado = this.detalleOrdenCompraService.guardar(d);
        if (creado == null) {
        	return new ResponseEntity<DetalleOrdenCompra>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getIdDetalleOrdenCompra()).toUri());
        return new ResponseEntity<DetalleOrdenCompra>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("detalleOrdenCompra")
	public ResponseEntity<DetalleOrdenCompra> actualizar(@RequestBody DetalleOrdenCompra d,UriComponentsBuilder builder) {
		DetalleOrdenCompra actualizar = this.detalleOrdenCompraService.guardar(d);
        return new ResponseEntity<DetalleOrdenCompra>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("detalleOrdenCompra/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idDetalleOrdenCompra) {
        this.detalleOrdenCompraService.borrar(idDetalleOrdenCompra);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
