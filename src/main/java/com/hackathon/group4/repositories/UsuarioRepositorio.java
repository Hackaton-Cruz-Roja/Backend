package com.hackathon.group4.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.group4.models.DAOUsuarios;

@Repository
public interface UsuarioRepositorio extends JpaRepository<DAOUsuarios, Integer> {

	
	/*
	 * void registrar(Usuarios usuario); List<Usuarios> getUsuarios(); void
	 * eliminar(Long id); List<Usuarios> findbyId();
	 * 
	 */
}
