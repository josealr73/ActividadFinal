package com.example.demoweb.service;

import java.util.List;

import com.example.demoweb.entity.Asignaturas;
import com.example.demoweb.entity.Usuario;

public interface AsignaturasService {
	List<Asignaturas> listAll();
	List<Asignaturas> listAdmin();
	List<Asignaturas> listConsultas();
	Asignaturas consultarPorID(Integer id);
	void eliminarTodos();
	void eliminarPorId(Integer id);
	Asignaturas modificar(Asignaturas a);
	Asignaturas insertar(Asignaturas a);
}
