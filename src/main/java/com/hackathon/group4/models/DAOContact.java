package com.hackathon.group4.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class DAOContact {
	public DAOContact() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_contact")
	private int idContact;
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "phone")
	private String phone;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private DAOUser user;
	@Column(name = "photo")
	private String photo;

}
