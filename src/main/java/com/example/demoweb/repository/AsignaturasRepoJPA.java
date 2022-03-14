package com.example.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoweb.entity.Asignaturas;

public interface AsignaturasRepoJPA extends JpaRepository<Asignaturas, Integer> {
	
}
