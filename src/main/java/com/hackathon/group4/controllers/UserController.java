package com.hackathon.group4.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.group4.models.DAOUser;
import com.hackathon.group4.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
		
//		@GetMapping("/find")
//		public List<DAOUser> getUsuarios() {
//			return userService.findAllUsers();
//		}
		
		@GetMapping("/find/{id}")
		public Optional<DAOUser> getUsuariosById(@PathVariable int id){
			return userService.findbyId(id);
		}
		
		/*@PostMapping("/adduser")
		public DAOUser addUsuarios(@RequestBody DAOUser user) {
			return  userService.saveUser(user);
		}*/
		
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
