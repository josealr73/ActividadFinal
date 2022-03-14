package com.example.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoweb.entity.Roles;

public interface RolesRepoJPA extends JpaRepository<Roles, Integer> {

}
