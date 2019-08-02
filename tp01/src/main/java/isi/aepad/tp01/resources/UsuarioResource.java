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

import isi.aepad.tp01.domain.Usuario;
import isi.aepad.tp01.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioResource {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("usuario")
	public ResponseEntity<List<Usuario>> buscar() {
		return  new ResponseEntity<List<Usuario>>(this.usuarioService.buscarTodos(), HttpStatus.OK);
	}

	
	@GetMapping("usuario/{idUsuario}")
	public ResponseEntity<Usuario> buscar(@PathVariable(required=false) String idUsuario) {
		return  new ResponseEntity<Usuario>(this.usuarioService.buscarPorId(idUsuario), HttpStatus.OK);
	}
	
	@PostMapping("usuario")
	public ResponseEntity<Usuario> crear(@RequestBody Usuario u,UriComponentsBuilder builder) {
		Usuario creado = this.usuarioService.guardar(u);
        if (creado == null) {
        	return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/usuario/{idUsuario}").buildAndExpand(creado.getUsername()).toUri());
        return new ResponseEntity<Usuario>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("usuario")
	public ResponseEntity<Usuario> actualizar(@RequestBody Usuario u,UriComponentsBuilder builder) {
		Usuario actualizar = this.usuarioService.guardar(u);
        return new ResponseEntity<Usuario>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("usuario/{idUsuario}")
	public ResponseEntity<Void> borrar(@RequestParam(value="idUsuario") String idUsuario) {
        this.usuarioService.borrar(idUsuario);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
