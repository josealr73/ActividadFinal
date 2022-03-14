package com.example.demoweb.service;

import java.util.List;

import com.example.demoweb.entity.Usuario;

public interface UsuarioService {
	Usuario buscarPorUsername(String username);
	public List<Usuario> listarFiltroAdmin();
	public List<Usuario> listarFiltroConsult();
}
