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

import isi.aepad.tp01.domain.Pedido;
import isi.aepad.tp01.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoResource {
	@Autowired
	private PedidoService pedidoService;

	@GetMapping("pedido")
	public ResponseEntity<List<Pedido>> buscar() {
		return  new ResponseEntity<List<Pedido>>(this.pedidoService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("pedido/{id}")
	public ResponseEntity<Pedido> buscar(@RequestParam(value="id") long idPedido) {
		return  new ResponseEntity<Pedido>(this.pedidoService.buscarPorId(idPedido), HttpStatus.OK);
	}
	
	@PostMapping("pedido")
	public ResponseEntity<Pedido> crear(@RequestBody Pedido p,UriComponentsBuilder builder) {
		Pedido creado = this.pedidoService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Pedido>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Pedido>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("pedido")
	public ResponseEntity<Pedido> actualizar(@RequestBody Pedido p,UriComponentsBuilder builder) {
		Pedido actualizar = this.pedidoService.guardar(p);
        return new ResponseEntity<Pedido>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("pedido/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idPedido) {
        this.pedidoService.borrar(idPedido);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
