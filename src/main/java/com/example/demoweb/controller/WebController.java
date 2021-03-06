package com.example.demoweb.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demoweb.entity.Usuario;
import com.example.demoweb.service.AsignaturasService;
import com.example.demoweb.service.UsuarioService;

@Controller
public class WebController {
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(WebController.class);
	
	@Autowired
	AsignaturasService asignaturaService;	
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping("/")
	public String index (Model m) {
		Usuario u = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		m.addAttribute("usuario", u);
		return "index";
	}
	
	@GetMapping("/listaDeAsignaturas")
	@Cacheable (value="usuario")
	public String listAsignaturas(Model m) {
		m.addAttribute("listaAsignaturas", asignaturaService.listAll());
		return "listAsignaturas";
	}
	
	@GetMapping("/listaDeAdmin")
	public String listsAdmin(Model m) {
		m.addAttribute("listaAdmin", usuarioService.listarFiltroAdmin());
		return "listAdmin";
	}
	
	@GetMapping("/listaDeConsult")
	public String listsConsultas(Model m) {
		m.addAttribute("listaConsult", usuarioService.listarFiltroConsult());
		return "listConsult";
	}
	
	
	@GetMapping("/error")
	public String errorPage() {
		return "error";
	}
}
