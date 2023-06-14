package com.microapi.microapi.OrderRecord;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;

@Entity
public class OrderRecord {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;//unique identifier, as opposed to POST-fed productID
	  @Column
	  private Long productID;
	  @Column
	  private String email;
	  @Column
	  private String first_name;
	  @Column
	  private String last_name;
	  @Column
	  private String avatar; //an URL
	  @Autowired
	  public OrderRecord() {
			//apparently, fasterxml.jackson insists i have this
		}
	
	public OrderRecord(Long productID, String email, String first_name, String last_name, String avatar) {
		this.productID = productID;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}

	//getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
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