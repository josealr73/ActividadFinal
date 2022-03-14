package com.example.demoweb.service;

import java.util.List;

import com.example.demoweb.entity.Asignaturas;
import com.example.demoweb.entity.Usuario;

public interface AsignaturasService {
	List<Asignaturas> listAll();
	List<Usuario> listAdmin();
	List<Usuario> listConsultas();
}
