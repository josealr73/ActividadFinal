package com.example.demoweb.controller;

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

import com.example.demoweb.entity.Asignaturas;
import com.example.demoweb.service.AsignaturasService;

@RestController
@RequestMapping ("/api/asignaturas")
public class AsignaturasRestController {

	@Autowired
	AsignaturasService asignaturasService;
	
	@Cacheable (value="asignaturas")
	@GetMapping
	public List<Asignaturas> listarAsignaturas(){
		try {
			Thread.sleep(500);
		}catch(InterruptedException exjj) {
			
		}
		return asignaturasService.listAll();
	}
	
	@GetMapping (value="/{id}")
	public ResponseEntity<Asignaturas> consultarId (@PathVariable("id") Integer id) {
		
		try {
			Asignaturas a = asignaturasService.consultarPorID(id);
			
			return new ResponseEntity<> (a, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	@CacheEvict (value="asignaturas", allEntries=true)
	public ResponseEntity<Asignaturas> insertarAsignatura (@RequestBody Asignaturas a) {
		HttpHeaders headers = new HttpHeaders();
		asignaturasService.insertar(a);
		
		try {
			if(a == null) {
				headers.set("Message", "Asignatura nulo");
				return new ResponseEntity<> (null, HttpStatus.NOT_ACCEPTABLE);
			}else {
				asignaturasService.insertar(a);
				return new ResponseEntity<> (a, HttpStatus.OK);
			}
		}catch(Exception e) {
			
		}
		
		return new ResponseEntity<> (a, headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping ()
	@CacheEvict (value="asignaturas", allEntries=true)
	public ResponseEntity<Asignaturas> eliminarTodasAsign() {
		try {
			asignaturasService.eliminarTodos();
			
			return new ResponseEntity<> (null, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@DeleteMapping (value="/{id}")
	@CacheEvict (value="asignaturas", allEntries=true)
	public ResponseEntity<Asignaturas> eliminarAsignPorId(@PathVariable("id") Integer id) {
		try {
			asignaturasService.eliminarPorId(id);
			
			return new ResponseEntity<> (null, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<> (null, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping
	@CacheEvict (value="asignaturas", allEntries=true)
	public ResponseEntity<Asignaturas> modificarAsignatura(@RequestBody Asignaturas a) {	
		try {
			asignaturasService.modificar(a);
			return new ResponseEntity<> (a, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
		}
	}
}
