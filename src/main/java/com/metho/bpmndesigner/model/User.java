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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * a user 
 */
@Document(collection="users")
public class User implements IStoreable {
	
	/**
	 * the id of the collection
	 * 
	 * @var int
	 */
	@Id
	private Integer id;
	
	/**
	 * the created date
	 * 
	 * @var DateTime
	 */
	private LocalDateTime created_at;
	
	/**
	 * the creater
	 * 
	 * @var user id
	 */
	@DBRef
	private User created_by;
	
	/**
	 * the last update date
	 */
	private LocalDateTime updated_at;
	
	/**
	 * the updater
	 */
	@DBRef
	private User updated_by;

	/**
	 * the first name of the person
	 */
	private String firstname;
	
	/**
	 * the last name of the person
	 */
	private String lastname;
	
	/**
	 * the email of the person
	 * the field is indexed
	 */
	@Indexed
	@Email
	private String email;
	
	/**
	 * the password of the person
	 * the field is indexed
	 */
	@Indexed
	private String password;
	
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
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * set the id of the user
	 * 
	 * @param int
	 * @return void
	 */
	public void setId(int id) {
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
	 * get the user as string
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", created_at=" + created_at + ", created_by=" + created_by + ", updated_at="
				+ updated_at + ", updated_by=" + updated_by + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + "]";
	}
	
}
