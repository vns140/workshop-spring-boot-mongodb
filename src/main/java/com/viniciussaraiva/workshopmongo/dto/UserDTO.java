package com.viniciussaraiva.workshopmongo.dto;

import java.io.Serializable;

import com.viniciussaraiva.workshopmongo.domain.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String email;	
	private String name;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		
		id = user.getId();
		email = user.getEmail();
		name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
