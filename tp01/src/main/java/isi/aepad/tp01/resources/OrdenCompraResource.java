package isi.aepad.tp01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isi.aepad.tp01.domain.OrdenCompra;
import isi.aepad.tp01.service.OrdenCompraService;

@RestController
@RequestMapping("/api")
public class OrdenCompraResource {
	@Autowired
	private OrdenCompraService ordenCompraService;

	@GetMapping("proyecto")
	public ResponseEntity<List<OrdenCompra>> buscar() {
		return  new ResponseEntity<List<OrdenCompra>>(this.ordenCompraService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("proyecto/{id}")
	public ResponseEntity<OrdenCompra> buscar(@RequestParam(value="id") long idOrdenCompra) {
		return  new ResponseEntity<OrdenCompra>(this.ordenCompraService.buscarPorId(idOrdenCompra), HttpStatus.OK);
	}
	
	@PostMapping("proyecto")
	public ResponseEntity<OrdenCompra> crear(@RequestBody OrdenCompra o,UriComponentsBuilder builder) {
		OrdenCompra creado = this.ordenCompraService.guardar(o);
        if (creado == null) {
        	return new ResponseEntity<OrdenCompra>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getIdOrdenCompra()).toUri());
        return new ResponseEntity<OrdenCompra>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("proyecto")
	public ResponseEntity<OrdenCompra> actualizar(@RequestBody OrdenCompra o,UriComponentsBuilder builder) {
		OrdenCompra actualizar = this.ordenCompraService.guardar(o);
        return new ResponseEntity<OrdenCompra>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("proyecto/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idOrdenCompra) {
        this.ordenCompraService.borrar(idOrdenCompra);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
