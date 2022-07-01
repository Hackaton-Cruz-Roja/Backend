package com.hackathon.group4.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private int idUser;
	private String identificator;
	private String password;
	private String name;
	private String surname;
	private String mail;
	private String phone;
	private String observations;
	private String registerDate;
}
