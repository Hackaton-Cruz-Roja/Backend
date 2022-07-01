package com.hackathon.group4.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackathon.group4.dao.UserDAO;
import com.hackathon.group4.models.DAOUser;
import com.hackathon.group4.models.UserDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String identificator) throws UsernameNotFoundException {
		DAOUser user = userDAO.findByIdentificator(identificator);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + identificator);
		}
		return new org.springframework.security.core.userdetails.User(user.getIdentificator(),user.getPassword(),new ArrayList<>());
	}
	

	public DAOUser loadUserByUsernameJWT(String identificator) throws UsernameNotFoundException {
		DAOUser user = userDAO.findByIdentificator(identificator);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + identificator);
		}
		return user;
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setIdUser(user.getIdUser());
		newUser.setIdentificator(user.getIdentificator());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setPhone(user.getPhone());
		newUser.setObservations(user.getObservations());
		newUser.setMail(user.getMail());
		return userDAO.save(newUser);
	}
}
