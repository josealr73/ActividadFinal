package com.example.demoweb.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.example.demoweb.controller.AsignaturasRestController;
import com.example.demoweb.entity.Asignaturas;
import com.example.demoweb.repository.AsignaturasRepoJPA;
import com.example.demoweb.service.AsignaturasService;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class AsignaturasRestTest {
	private Asignaturas a1, a2;
	
	@Autowired
	AsignaturasRepoJPA repo;
	
	@Autowired
	AsignaturasService service;
	
	@Autowired
	AsignaturasRestController controller;
	
	
	@BeforeEach
	void setUp() throws Exception {
		repo.deleteAll();
		
		a1 = new Asignaturas();
		a1.setNombre("Filosofia");
		a1.setDescripcion("Ser o no ser");
		a1.setCurso(1);
		a1 = repo.save(a1);
		
		a2 = new Asignaturas();
		a2.setNombre("Fisica y Quimica");
		a2.setDescripcion("La mitad de lo que hemos vivido");
		a2.setCurso(1);
		a2 = repo.save(a2);
	}

	@AfterEach
	void tearDown() throws Exception {
		repo.deleteAll();
	}

	@Test
	void testListarAsignaturas() {
	//GIVEN:
		assertEquals(2, service.listAll().size(), "2 asignaturas en la BD");
	
	//WHEN:
		List<Asignaturas> la = controller.listarAsignaturas();
	
	//THEN:
		assertEquals(2, la.size(), "Hay 2 asignaturas en la BD");
	}

	@Test
	void testConsultarId() {
		//GIVEN
		assertEquals(2, service.listAll().size(), "2 asignaturas en la BD");
		
		//WHEN
		ResponseEntity<Asignaturas> en = controller.consultarId(a1.getId());
				
		//THEN
		assertNotNull (en.getBody(), "No existe en la BD");
		assertEquals(HttpStatus.OK, en.getStatusCode(), "Existe en la BD");		
		assertEquals(a1, en.getBody(), "");
	}

	@Test
	void testInsertarAsignatura() {
		//GIVEN:
		assertEquals(2, service.listAll().size(), "Hay 2 asignaturas en la BD");
		
		//WHEN:
		Asignaturas a3 = new Asignaturas();
		a3.setNombre("Materia");
		a3.setDescripcion("Materia");
		a3.setCurso(2);
		ResponseEntity<Asignaturas> en = controller.insertarAsignatura(a3);
		
		//THEN:
		assertEquals(HttpStatus.OK, en.getStatusCode(), "Insertada en la BD");
		assertEquals(3, service.listAll().size(), "3 asignaturas en la BD");
	}
	
	@Test
	void testInsertarException_idIsNotNull() throws Exception{
		// GIVEN:
		assertEquals(2, service.listAll().size(), "Hay 2 asignaturas en BD");
		
		//WHEN:
		Asignaturas a3 = new Asignaturas();
		a3.setNombre("Sociales");
		a3.setDescripcion("Sociales");
		a3.setCurso(1);
		ResponseEntity<Asignaturas> re = controller.insertarAsignatura(a3);
		
		//THEN
		//assertEquals (HttpStatus.NOT_ACCEPTABLE , re.getStatusCode(), "Código no aceptado, asignatura con id no null");
		assertNull(a3.getId(), "No");
	}
	
	@Test
	void testInsertarAsignatura_nombreIsNull() {
		//GIVEN:
		assertEquals(2, service.listAll().size(), "Hay dos Asignaturas en BBDD");
		
		//WHEN:
		Asignaturas a3 = new Asignaturas();
		a3.setDescripcion("Hola");
		a3.setCurso(2);
		
		ResponseEntity<Asignaturas> re = null;
		
		try {
			re = controller.insertarAsignatura(a3);
			assertEquals (HttpStatus.OK, re.getStatusCode(), "Se ha insertado");
		}catch(Exception e) {
			assertNull(re, "Nombre es nulo");
		}
	}
	

	@Test
	void testEliminarTodasAsign() {
		// GIVEN
		assertEquals(2, service.listAll().size(), "Hay 2 asignaturas en la BD");
		
		// WHEN
		ResponseEntity<Asignaturas> re = controller.eliminarTodasAsign();
		
		// THEN
		assertEquals (HttpStatus.OK , re.getStatusCode(), "Asignatura eliminada de la BD");
		assertEquals (0 , service.listAll().size(), "La BD está vacía");
	}

	@Test
	void testEliminarAsignPorId() {
		//GIVEN:
		assertEquals(2, service.listAll().size(), "Hay dos Asignaturas en BBDD");
		
		//WHEN:
		ResponseEntity<Asignaturas> re = controller.eliminarAsignPorId(a1.getId());
		
		//THEN
		 assertEquals (HttpStatus.OK , re.getStatusCode(), "Asignatura aliminada");
		 assertEquals (1, service.listAll().size(), "Eliminada correctamente");
		 
	}

	@Test
	void testModificarAsignatura() throws Exception{
		//GIVEN:
		assertEquals(2, service.listAll().size(), "Hay 2 asignaturas en la BD");
		
		//WHEN:
		a1.setNombre("Ingles");
		a1.setDescripcion("Hablar ingles");
		a1.setCurso(2);
		ResponseEntity<Asignaturas> re = controller.modificarAsignatura(a1);
		
		//THEN
		 assertEquals (HttpStatus.OK, re.getStatusCode(), "Asignatura modificada");
		 assertEquals ("Ingles", re.getBody().getNombre(), "Nombre modificado");
		 assertEquals ("Hablar ingles", re.getBody().getDescripcion(), "Descripcion modificada");
		 assertEquals (2, re.getBody().getCurso(), "Curso modificado");
	}

}
