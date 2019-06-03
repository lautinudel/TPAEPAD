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

import isi.aepad.tp01.domain.Localidad;
import isi.aepad.tp01.service.LocalidadService;


@RestController
@RequestMapping("/api")
public class LocalidadResource {
	@Autowired
	private LocalidadService localidadService;

	@GetMapping("localidad")
	public ResponseEntity<List<Localidad>> buscar() {
		return  new ResponseEntity<List<Localidad>>(this.localidadService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("localidad/{id}")
	public ResponseEntity<Localidad> buscar(@RequestParam(value="id") long idLocalidad) {
		return  new ResponseEntity<Localidad>(this.localidadService.buscarPorId(idLocalidad), HttpStatus.OK);
	}
	
	@PostMapping("localidad")
	public ResponseEntity<Localidad> crear(@RequestBody Localidad l,UriComponentsBuilder builder) {
		Localidad creado = this.localidadService.guardar(l);
        if (creado == null) {
        	return new ResponseEntity<Localidad>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Localidad>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("localidad")
	public ResponseEntity<Localidad> actualizar(@RequestBody Localidad l,UriComponentsBuilder builder) {
		Localidad actualizar = this.localidadService.guardar(l);
        return new ResponseEntity<Localidad>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("localidad/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idLocalidad) {
        this.localidadService.borrar(idLocalidad);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
