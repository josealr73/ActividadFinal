package com.example.demoweb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.demoweb.controller.AsignaturasRestController;
import com.example.demoweb.entity.Asignaturas;
import com.example.demoweb.repository.AsignaturasRepoJPA;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class AsignaturasServiceTest {
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
		a1.setNombre("Historia");
		a1.setDescripcion("Aprender Historia");
		a1.setCurso(2);
		a1 = repo.save(a1);
		
		a2 = new Asignaturas();
		a2.setNombre("Sociales");
		a2.setDescripcion("Descripcion");
		a2.setCurso(3);
		a2 = repo.save(a2);
	}

	@AfterEach
	void tearDown() throws Exception {
		repo.deleteAll();
	}

	@Test
	void testListAll() {
		// GIVEN
		assertEquals(2, service.listAll().size(), "Coincide coincide con la cantidad de asignaturas de la BD");
	}

	@Test
	void testConsultarPorID() {
		Integer id;
		Asignaturas a3 = new Asignaturas();
		a3 = service.consultarPorID(a1.getId());
		
		assertTrue(a3.equals(a1), "Mismo objeto. Existe.");
	}

	@Test
	void testEliminarTodos() {
		service.eliminarTodos();
		
		assertEquals(0, service.listAll().size(), "No hay asignaturas en la BD");
	}

	@Test
	void testEliminarPorId() {
		Asignaturas a3 = new Asignaturas();
		a3 = a1;
		
		service.eliminarPorId(a3.getId());
		
		assertEquals(2, service.listAll().size(), "2 asignaruas en la BD");
	}

	@Test
	void testModificar() {
		String nombre = "Religion";
		a2.setNombre(nombre);
		service.modificar(a2);
		
		assertEquals(nombre, a2.getNombre(), "Mismo nombre");
	}

	@Test
	void testInsertar() {
		assertEquals(2, service.listAll().size(), "Hay 2 asignaturas en la BD");
		
		Asignaturas a3 = new Asignaturas();
		
		a3.setNombre("Fisica");
		a3.setDescripcion("Fisica");
		a3.setCurso(2);
		a3 = service.insertar(a3);
		
		assertEquals(3, service.listAll().size(), "Asignatura insertada en la BD");
	}
}