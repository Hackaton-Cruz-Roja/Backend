package com.hackathon.group4.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class DAOMessage {
	public DAOMessage() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_message")
	private int idMessage;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private DAOUser user;
	@OneToMany
	@JoinColumn(name = "id_contact")
	private List<DAOContact> contact;
	@Column(name = "title")
	private String title;
	@Column(name = "type")
	private Integer type;
	@Column(name = "message")
	private String message;

}
