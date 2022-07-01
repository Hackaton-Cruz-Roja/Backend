package com.hackathon.group4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.group4.models.DAOUser;
import com.hackathon.group4.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public List<DAOUser> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<DAOUser> findbyId(int id) {
		return userRepository.findById(id);
	}

	@Override
	public DAOUser saveUser(DAOUser newUser) {
		if (newUser != null) {
			return userRepository.save(newUser);
		}
		return newUser;
	}

	@Override
	public String deleteUser(int id) {
		
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El usuario no existe";
	}

	@Override
	public void updateUser(DAOUser newUser, int id) {
	
			Optional<DAOUser> user = userRepository.findById(id);
			
			DAOUser userEntity = user.get();

			userEntity.setMail(newUser.getMail());
			userEntity.setName(newUser.getName());
			userEntity.setIdentificator(newUser.getIdentificator());
			userEntity.setPassword(newUser.getPassword());
			userEntity.setSurname(newUser.getSurname());
			
			userRepository.save(userEntity);
		
	}

}
