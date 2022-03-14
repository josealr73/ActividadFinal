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
	public List<Usuario> listAdmin() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Usuario> listConsultas() {
		// TODO Auto-generated method stub
		return null;
	}

}
