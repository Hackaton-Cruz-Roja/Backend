package com.hackathon.group4.userServices;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackathon.group4.dao.UsuarioDAO;
import com.hackathon.group4.models.DAOUsuarios;
import com.hackathon.group4.models.UsuarioDTO;

@Service
public class CustomUsuarioDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
		DAOUsuarios usuario = usuarioDAO.findByNickname(nickname);
		if (usuario == null) {
			throw new UsernameNotFoundException("User not found with username: " + nickname);
		}
		return new org.springframework.security.core.userdetails.User(usuario.getNickname(),usuario.getPassword(),new ArrayList<>());
	}
	

	public DAOUsuarios loadUserByUsernameJWT(String nickname) throws UsernameNotFoundException {
		DAOUsuarios usuario = usuarioDAO.findByNickname(nickname);
		if (usuario == null) {
			throw new UsernameNotFoundException("User not found with username: " + nickname);
		}
		return usuario;
	}
	
	public DAOUsuarios save(UsuarioDTO usuario) {
		DAOUsuarios nuevoUsuario = new DAOUsuarios();
		nuevoUsuario.setNickname(usuario.getNickname());
		nuevoUsuario.setPassword(bcryptEncoder.encode(usuario.getPassword()));
		nuevoUsuario.setId_user(usuario.getId_user());
		nuevoUsuario.setName(usuario.getName());
		nuevoUsuario.setMail(usuario.getMail());
		nuevoUsuario.setRegister_date(usuario.getRegister_date());
		nuevoUsuario.setSurname(usuario.getSurname());
		return usuarioDAO.save(nuevoUsuario);
	}
}
