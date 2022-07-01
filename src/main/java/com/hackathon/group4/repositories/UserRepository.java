package com.hackathon.group4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.group4.models.DAOUser;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, Integer> {

	
	/*
	 * void registrar(Usuarios usuario); List<Usuarios> getUsuarios(); void
	 * eliminar(Long id); List<Usuarios> findbyId();
	 * 
	 */
}
