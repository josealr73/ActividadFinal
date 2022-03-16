package com.example.demoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoweb.entity.Asignaturas;
import com.example.demoweb.entity.Usuario;
import com.example.demoweb.repository.AsignaturasRepoJPA;

@Service
public class AsignaturasServiceImpl implements AsignaturasService{
	@Autowired
	AsignaturasRepoJPA asignaturasRepo;
	
	@Override
	public List<Asignaturas> listAll() {
		// TODO Auto-generated method stub
		return asignaturasRepo.findAll();
	}


	@Override
	public List<Asignaturas> listAdmin() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Asignaturas> listConsultas() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Asignaturas consultarPorID(Integer id) {
		// TODO Auto-generated method stub
		return asignaturasRepo.findById(id).orElse(null);
	}


	@Override
	public void eliminarTodos() {
		// TODO Auto-generated method stub
		asignaturasRepo.deleteAll();
	}


	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		asignaturasRepo.deleteById(id);
	}


	@Override
	public Asignaturas modificar(Asignaturas a) {
		// TODO Auto-generated method stub
		return asignaturasRepo.save(a);
	}


	@Override
	public Asignaturas insertar(Asignaturas a) {
		// TODO Auto-generated method stub
		return asignaturasRepo.save(a);
	}






}
