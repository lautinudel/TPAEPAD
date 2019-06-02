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

import isi.aepad.tp01.domain.Cliente;
import isi.aepad.tp01.service.ClienteService;


@RestController
@RequestMapping("/api")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;

	@GetMapping("proyecto")
	public ResponseEntity<List<Cliente>> buscar() {
		return  new ResponseEntity<List<Cliente>>(this.clienteService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("proyecto/{id}")
	public ResponseEntity<Cliente> buscar(@RequestParam(value="id") long idCliente) {
		return  new ResponseEntity<Cliente>(this.clienteService.buscarPorId(idCliente), HttpStatus.OK);
	}
	
	@PostMapping("proyecto")
	public ResponseEntity<Cliente> crear(@RequestBody Cliente c,UriComponentsBuilder builder) {
        Cliente creado = this.clienteService.guardar(c);
        if (creado == null) {
        	return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getIdCliente()).toUri());
        return new ResponseEntity<Cliente>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("proyecto")
	public ResponseEntity<Cliente> actualizar(@RequestBody Cliente c,UriComponentsBuilder builder) {
        Cliente actualizar = this.clienteService.guardar(c);
        return new ResponseEntity<Cliente>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("proyecto/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") long idCliente) {
        this.clienteService.borrar(idCliente);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
