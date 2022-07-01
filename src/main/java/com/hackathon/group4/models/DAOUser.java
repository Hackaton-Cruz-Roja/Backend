package com.hackathon.group4.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class DAOUser {
	public DAOUser() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	@Column(name = "identificator")
	private String identificator;
	@Column(name = "password",length = 3000)
	@JsonIgnore
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "mail")
	private String mail;
	@Column(name = "phone")
	private String phone;
	@Column(name = "observations")
	private String observations;

}
