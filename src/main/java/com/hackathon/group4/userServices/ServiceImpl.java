package com.hackathon.group4.userServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.group4.models.DAOUsuarios;
import com.hackathon.group4.repositories.UsuarioRepositorio;

@Service
public class ServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	

	@Override
	public List<DAOUsuarios> findAllUsers() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Optional<DAOUsuarios> findbyId(int id) {
		return usuarioRepositorio.findById(id);
	}

	@Override
	public DAOUsuarios saveUsuario(DAOUsuarios usuarioNuevo) {
		if (usuarioNuevo != null) {
			return usuarioRepositorio.save(usuarioNuevo);
		}
		return usuarioNuevo;
	}

	@Override
	public String deleteUsuarios(int id) {
		
		if (usuarioRepositorio.findById(id).isPresent()) {
			usuarioRepositorio.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El usuario no existe";
	}

	@Override
	public void updateUsuarios(DAOUsuarios usuarioCambiado, int id) {
	
			Optional<DAOUsuarios> user = usuarioRepositorio.findById(id);
			
			DAOUsuarios usuariosParaCambiar = user.get();
			
			usuariosParaCambiar.setRegister_date(usuarioCambiado.getRegister_date());
			usuariosParaCambiar.setMail(usuarioCambiado.getMail());
			usuariosParaCambiar.setName(usuarioCambiado.getName());
			usuariosParaCambiar.setNickname(usuarioCambiado.getNickname());
			usuariosParaCambiar.setPassword(usuarioCambiado.getPassword());
			usuariosParaCambiar.setSurname(usuarioCambiado.getSurname());
			
			usuarioRepositorio.save(usuariosParaCambiar);
		
	}

}
