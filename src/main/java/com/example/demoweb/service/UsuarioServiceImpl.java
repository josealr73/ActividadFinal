package com.example.demoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demoweb.entity.Usuario;
import com.example.demoweb.repository.UsuarioRepoJPA;
import com.example.demoweb.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	
	@Autowired
	UsuarioRepoJPA usuarioRepo;
	
	
	@Override
	public Usuario buscarPorUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioRepo.findById(username).get();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return buscarPorUsername(username);
	}

	@Override
	public List<Usuario> listarFiltroAdmin() {
		// TODO Auto-generated method stub
		return usuarioRepo.listarAdmin();
	}

	@Override
	public List<Usuario> listarFiltroConsult() {
		// TODO Auto-generated method stub
		return usuarioRepo.listarConsult();
		
	}

	@Override
	public List<Usuario> consultarTodos() {
		// TODO Auto-generated method stub
		return usuarioRepo.findAll();
	}
	
	@Override
	public Usuario insertar(Usuario u) {
		// TODO Auto-generated method stub
		return usuarioRepo.save(u);
	}
	
	@Override
	public Usuario modificar(Usuario u) {
		return usuarioRepo.save(u);
	}

	
	@Override
	public void eliminarTodos() {
		usuarioRepo.deleteAll();
	}
	
	@Override
	public void eliminarPorId(String user) {
		usuarioRepo.deleteById(user);
	}
	
	@Override
	public Usuario consultarPorID(String user) {
		// TODO Auto-generated method stub
		return usuarioRepo.findById(user).orElse(null);
	}
}