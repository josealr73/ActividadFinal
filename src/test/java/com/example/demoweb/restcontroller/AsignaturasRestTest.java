package com.example.demoweb.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
		fail("Not yet implemented");
	}

	@Test
	void testInsertarAsignatura() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminarTodasAsign() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminarAsignPorId() {
		fail("Not yet implemented");
	}

	@Test
	void testModificarAsignatura() {
		fail("Not yet implemented");
	}

}
