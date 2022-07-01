package com.hackathon.group4.service;

import java.util.List;
import java.util.Optional;

import com.hackathon.group4.models.DAOUser;

public interface UserService {

	
	public List<DAOUser> findAllUsers();
	
	public Optional<DAOUser> findbyId(int id);

	public DAOUser saveUser(DAOUser newUser);

	public String deleteUser(int id);

	public void updateUser(DAOUser newUser, int id);

}
