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

import isi.aepad.tp01.domain.Pago;
import isi.aepad.tp01.service.PagoService;

@RestController
@RequestMapping("/api")
public class PagoResource {
	@Autowired
	private PagoService pagoService;

	@GetMapping("pago")
	public ResponseEntity<List<Pago>> buscar() {
		return  new ResponseEntity<List<Pago>>(this.pagoService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("pago/{id}")
	public ResponseEntity<Pago> buscar(@RequestParam(value="id") long idPago) {
		return  new ResponseEntity<Pago>(this.pagoService.buscarPorId(idPago), HttpStatus.OK);
	}
	
	@PostMapping("pago")
	public ResponseEntity<Pago> crear(@RequestBody Pago p,UriComponentsBuilder builder) {
		Pago creado = this.pagoService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Pago>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getIdPago()).toUri());
        return new ResponseEntity<Pago>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("pago")
	public ResponseEntity<Pago> actualizar(@RequestBody Pago p,UriComponentsBuilder builder) {
		Pago actualizar = this.pagoService.guardar(p);
        return new ResponseEntity<Pago>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("pago/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idPago) {
        this.pagoService.borrar(idPago);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
