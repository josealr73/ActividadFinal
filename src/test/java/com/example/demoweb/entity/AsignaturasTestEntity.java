package com.example.demoweb.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class AsignaturasTestEntity {
	
	@AfterEach
	void tearDown() throws Exception {
		
	}

	/**
	 * Comprueba si dos objetos Asignatura son iguales mediante su campo ID
	 */
	@Test
	void mismoID() {
		Asignaturas a1 = new Asignaturas();
		
		a1.setId(1);
		a1.setNombre("Fisica");
		a1.setDescripcion("No se");
		a1.setCurso(2);
		
		Asignaturas a2 = new Asignaturas();
		a2.setId(1);
		a2.setNombre("Fisica");
		a2.setDescripcion("No se");
		a2.setCurso(2);
	
		assertEquals(a1, a2, "Son iguales");
	}
	
	@Test
	void distintoID() {
		Asignaturas a1 = new Asignaturas();
		
		a1.setId(2);
		a1.setNombre("Conocimiento");
		a1.setDescripcion("Si");
		a1.setCurso(1);
		
		Asignaturas a2 = new Asignaturas();
		a2.setId(1);
		a2.setNombre("Fisica");
		a2.setDescripcion("No se");
		a2.setCurso(2);
	
		assertNotEquals(a1, a2, "Son distintos");
	}
	
	@Test
	void mismoObjeto() {
		Asignaturas a1 = new Asignaturas();
		a1.setId(2);
		a1.setNombre("Conocimiento");
		a1.setDescripcion("Si");
		a1.setCurso(1);
		
		assertEquals(a1, a1, "Mismo objeto");
	}
	
	@Test
	void idNull() {
		Asignaturas a1 = new Asignaturas();
		a1.setId(null);
		a1.setNombre("Conocimiento");
		a1.setDescripcion("Si");
		a1.setCurso(1);
		
		assertNull(a1.getId(), "Id nulo");
	}
}
