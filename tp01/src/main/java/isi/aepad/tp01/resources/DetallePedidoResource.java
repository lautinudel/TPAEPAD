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

import isi.aepad.tp01.domain.DetallePedido;
import isi.aepad.tp01.service.DetallePedidoService;

@RestController
@RequestMapping("/api")
public class DetallePedidoResource {
	@Autowired
	private DetallePedidoService detallePedidoService;	

	@GetMapping("detallePedido")
	public ResponseEntity<List<DetallePedido>> buscar() {
		return  new ResponseEntity<List<DetallePedido>>(this.detallePedidoService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("detallePedido/{id}")
	public ResponseEntity<DetallePedido> buscar(@RequestParam(value="id") long idDetalleOrdenCompra) {
		return  new ResponseEntity<DetallePedido>(this.detallePedidoService.buscarPorId(idDetalleOrdenCompra), HttpStatus.OK);
	}
	
	@PostMapping("detallePedido")
	public ResponseEntity<DetallePedido> crear(@RequestBody DetallePedido d,UriComponentsBuilder builder) {
		DetallePedido creado = this.detallePedidoService.guardar(d);
        if (creado == null) {
        	return new ResponseEntity<DetallePedido>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getIdDetallePedido()).toUri());
        return new ResponseEntity<DetallePedido>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("detallePedido")
	public ResponseEntity<DetallePedido> actualizar(@RequestBody DetallePedido d,UriComponentsBuilder builder) {
		DetallePedido actualizar = this.detallePedidoService.guardar(d);
        return new ResponseEntity<DetallePedido>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("detallePedido/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idDetallePedido) {
        this.detallePedidoService.borrar(idDetallePedido);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
