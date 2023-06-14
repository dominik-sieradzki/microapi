package com.microapi.microapi.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Data {

	  @Id
	  private Long id;
	  private String email;
	  private String first_name;
	  private String last_name;
	  private String avatar; //an URL
	public Data() {
		//apparently, fasterxml.jackson insists i have this
	}
	public Data(Long id, String email, String first_name, String last_name, String avatar) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}



