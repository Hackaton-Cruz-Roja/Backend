package com.hackathon.group4.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.group4.models.DAOUser;

@Repository
public interface UserDAO extends CrudRepository<DAOUser, Integer> {

	DAOUser findByIdentificator(String identificator);
	 

}
