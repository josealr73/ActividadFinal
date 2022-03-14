package com.example.demoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demoweb.entity.Usuario;

public interface UsuarioRepoJPA extends JpaRepository<Usuario, String>, UsuarioRepo{
		@Query(value="select * from usuario where rol_id=1", nativeQuery=true)
		public List<Usuario> listarAdmin();
		
		@Query(value="select * from usuario where rol_id=2", nativeQuery=true)
		public List<Usuario> listarConsult();
}
