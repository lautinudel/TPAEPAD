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

import isi.aepad.tp01.domain.MedioDePago;
import isi.aepad.tp01.service.MedioDePagoService;

@RestController
@RequestMapping("/api")
public class MedioDePagoResource {
	@Autowired
	private MedioDePagoService medioDePagoService;

	@GetMapping("proyecto")
	public ResponseEntity<List<MedioDePago>> buscar() {
		return  new ResponseEntity<List<MedioDePago>>(this.medioDePagoService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("proyecto/{id}")
	public ResponseEntity<MedioDePago> buscar(@RequestParam(value="id") long idMedioDePago) {
		return  new ResponseEntity<MedioDePago>(this.medioDePagoService.buscarPorId(idMedioDePago), HttpStatus.OK);
	}
	
	@PostMapping("proyecto")
	public ResponseEntity<MedioDePago> crear(@RequestBody MedioDePago m,UriComponentsBuilder builder) {
		MedioDePago creado = this.medioDePagoService.guardar(m);
        if (creado == null) {
        	return new ResponseEntity<MedioDePago>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<MedioDePago>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("proyecto")
	public ResponseEntity<MedioDePago> actualizar(@RequestBody MedioDePago m,UriComponentsBuilder builder) {
		MedioDePago actualizar = this.medioDePagoService.guardar(m);
        return new ResponseEntity<MedioDePago>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("proyecto/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idMedioDePago) {
        this.medioDePagoService.borrar(idMedioDePago);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
