package com.hackathon.group4.models;

import java.io.Serializable;
import lombok.Data;

@Data
public class JwtRequest implements Serializable {
private static final long serialVersionUID = 5926468583005150707L;
	
	private String identificator;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

}
