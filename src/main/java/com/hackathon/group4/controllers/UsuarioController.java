package com.hackathon.group4.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.group4.models.DAOUsuarios;
import com.hackathon.group4.userServices.UsuarioService;

@RestController
public class UsuarioController {
	
	 @Autowired
	 private UsuarioService usuarioService;
	 
	 @Autowired
		private JdbcTemplate jdbcTemplate;
	 
		
		@GetMapping("/users")
		public List<DAOUsuarios> getUsuarios() {
			return usuarioService.findAllUsers();
		}
		
		@GetMapping("/users/{id}")
		public Optional<DAOUsuarios> getUsuariosById(@PathVariable int id){
			return usuarioService.findbyId(id);
		}
		
		@PostMapping("/users/adduser")
		public DAOUsuarios addUsuarios(@RequestBody DAOUsuarios usuario) {
			return  usuarioService.saveUsuario(usuario);
		}
		
		/*
		@PostMapping("/users/deleteuser/{id}")
		public String deleteUsuario(@PathVariable int id) {
			return usuarioService.deleteUsuarios(id);
		}
		
		@PutMapping("/users/update/{id}")
		public ResponseEntity<Object> updateUsuario(@RequestBody DAOUsuarios usuarioNuevo, @PathVariable int id) {
			
			usuarioService.updateUsuarios(usuarioNuevo, id);
			return ResponseEntity.ok(Boolean.TRUE);
			
		}*/
		

}
