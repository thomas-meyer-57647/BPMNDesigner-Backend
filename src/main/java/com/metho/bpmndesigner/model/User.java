package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * a user 
 * 
 * long id										the id of the collection
 * LocalDateTime created_at						the created date
 * User created_by								the creator
 * LocalDateTime updated_at						the last update date
 * User updated_by								the updater
 * String firstname								the first name of the person
 * String lastname								the last name of the person
 * String email									the email of the person. Indexed
 * String password								the password of the person
 * String secret								a secret key for reset the password
 */
@Document(collection="users")
public class User implements IStoreable {

	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private long id;							// the id of the document
	private LocalDateTime created_at;			// the created date
	
	@DBRef
	private User created_by;					// the creator
	
	private LocalDateTime updated_at;			// the last update date
	
	@DBRef
	private User updated_by;					// the updater
	
    @Size(max=100)
	private String firstname;					// the first name of the person
    
	@NotBlank
    @Size(max=100)
	private String lastname;					// the last name of the person

	@NotBlank
    @Size(max=100)	
	@Email
	@Indexed									// (unique=true)
	private String email;						// the email of the person
	
	@NotBlank
    @Size(max=100)	
	@Indexed 									
	private String password;					// the password of the person
	
	@Indexed 									
	private String secret;						// a secret key for reset the password
	
	/**
	 * default constructor 
	 */
	public User() {
		super();
	}

	// GETTER / SETTER
	/**
	 * get the id of the user
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set the id of the user
	 * 
	 * @param long
	 * @return void
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * get the first creation date
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getCreatedAt() {
		return created_at;
	}
	
	/**
	 * set the first creation date
	 * 
	 * @param LocalDateTime
	 * @return void
	 */
	public void setCreatedAt(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	/**
	 * get the first creator
	 * 
	 * @return User
	 */
	public User getCreatedBy() {
		return created_by;
	}
	
	/**
	 * set the first creator
	 * 
	 * @param User
	 * @return void
	 */
	public void setCreatedBy(User created_by) {
		this.created_by = created_by;
	}
	
	/**
	 * get the last update
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getUpdatedAt() {
		return updated_at;
	}
	
	/**
	 * set the last update
	 * 
	 * @param LocalDateTime
	 * @return
	 */
	public void setUpdatedAt(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	/**
	 * get the last updater
	 * 
	 * @return LocalDateTime
	 */
	public User getUpdatedBy() {
		return updated_by;
	}
	
	/**
	 * set the last updater
	 * 
	 * @return LocalDateTime
	 */
	public void setUpdatedBy(User updated_by) {
		this.updated_by = updated_by;
	}
	
	/**
	 * get the firstname of the user
	 * 
	 * @return String
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * set the firstname of the user
	 * 
	 * @param String
	 * @return void
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * get the lastname of the user
	 * 
	 * @return String
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * set the lastname of the user
	 * 
	 * @param String
	 * @return void
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * get the email of the user
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * set the email of the user
	 * 
	 * @param String
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * get the password of the user
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set the password of the user
	 * 
	 * @param String
	 * @return void
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get a secret key for reset the password
	 * 
	 * @return String
	 */
	public String getSecret() {
		return secret;
	}
	
	/**
	 * set a secret key for reset the password
	 * 
	 * @oaram String
	 * @return void
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * get the user as string
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", created_at=" + created_at + ", created_by=" + created_by + ", updated_at="
				+ updated_at + ", updated_by=" + updated_by + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + ", secret=" + secret + "]";
	}
}
