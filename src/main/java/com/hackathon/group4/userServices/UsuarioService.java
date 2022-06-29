package com.hackathon.group4.userServices;

import java.util.List;
import java.util.Optional;

import com.hackathon.group4.models.DAOUsuarios;

public interface UsuarioService {

	
	public List<DAOUsuarios> findAllUsers();
	
	public Optional<DAOUsuarios> findbyId(int id);

	public DAOUsuarios saveUsuario(DAOUsuarios usuarioNuevo);

	public String deleteUsuarios(int id);

	public void updateUsuarios(DAOUsuarios UsuarioNuevo, int id);

}
