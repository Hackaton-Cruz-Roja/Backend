package com.hackathon.group4.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.group4.models.DAOUsuarios;

@Repository
public interface UsuarioDAO extends CrudRepository<DAOUsuarios, Integer> {

	DAOUsuarios findByNickname(String nickname);
	 

}
