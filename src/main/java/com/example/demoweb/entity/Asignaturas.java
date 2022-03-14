package com.example.demoweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Asignaturas {
	@Id
	@Column
	private Integer id;
	
	@Column(nullable=false, length=20)
	private String nombre;
	
	@Column(length=50)
	private String descripcion;
	
	@Column
	private Integer curso;

	public Integer getNumber() {
		return id;
	}

	public void setNumber(Integer number) {
		this.id = number;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}
}