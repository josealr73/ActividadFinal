package com.example.demoweb.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demoweb.entity.Usuario;
import com.example.demoweb.service.UsuarioService;

@RestController
@RequestMapping ("/api/usuarios")
public class UsuariosRestController {

	@Autowired
	UsuarioService usuarioService;
	
	@Cacheable (value="usuarios")
	@GetMapping
	public List<Usuario> listarUsuarios(){
		try {
			Thread.sleep(500);
		}catch(InterruptedException exjj) {
			
		}
		return usuarioService.consultarTodos();
	}
	
	@GetMapping (value="/{username}")
	public ResponseEntity<Usuario> consultarId (@PathVariable("username") String user) {
		Usuario u = usuarioService.consultarPorID(user);
		
		if(u == null) {
			return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<> (u, HttpStatus.OK);
		}
	}
	
	@PostMapping
	@CacheEvict (value="usuarios", allEntries=true)
	public void insertarUsuario (@RequestBody Usuario u) {
		usuarioService.insertar(u);
	}

	
	@DeleteMapping ()
	@CacheEvict (value="usuarios", allEntries=true)
	public void eliminarTodosUser() {
		usuarioService.eliminarTodos();
	}
	
	
	@DeleteMapping (value="/{username}")
	@CacheEvict (value="usuarios", allEntries=true)
	public void eliminarUserPorId(@PathVariable("username") String user) {
		usuarioService.eliminarPorId(user);
	}
	
	@PutMapping
	@CacheEvict (value="usuarios", allEntries=true)
	public Usuario modificarUsuario(@RequestBody Usuario u) {
		return usuarioService.modificar(u);
	}
}
