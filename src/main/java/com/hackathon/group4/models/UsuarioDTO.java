package com.hackathon.group4.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	private int id_user;
	private String nickname;
	private String password;
	private String name;
	private String surname;
	private String mail;
	private String register_date;
}
