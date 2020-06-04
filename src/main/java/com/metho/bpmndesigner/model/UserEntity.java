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
import org.springframework.data.mongodb.core.mapping.Field;

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
public class UserEntity implements IStoreable {

	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private long id;								// the id of the document
	
	@Field("created_at")	
	private LocalDateTime createdAt;				// the created date
	
	@DBRef
	@Field("created_by")
	private UserEntity createdBy;					// the creator
	
	@Field("updated_at")
	private LocalDateTime updatedAt;				// the last update date
	
	@DBRef
	@Field("updated_by")	
	private UserEntity updatedBy;					// the updater
	
    @Size(max=100)
	private String firstname;					// the first name of the person
    
	@NotBlank
    @Size(max=100)
	private String lastname;					// the last name of the person

	@NotBlank
    @Size(max=100)	
	@Email
	@Indexed(unique = true)						// (unique=true)
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
	public UserEntity() {
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
		return createdAt;
	}
	
	/**
	 * set the first creation date
	 * 
	 * @param LocalDateTime
	 * @return void
	 */
	public void setCreatedAt(LocalDateTime created_at) {
		this.createdAt = created_at;
	}
	
	/**
	 * get the first creator
	 * 
	 * @return User
	 */
	public UserEntity getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * set the first creator
	 * 
	 * @param UserEntity
	 * @return void
	 */
	public void setCreatedBy(UserEntity created_by) {
		this.createdBy = created_by;
	}
	
	/**
	 * get the last update
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * set the last update
	 * 
	 * @param LocalDateTime
	 * @return
	 */
	public void setUpdatedAt(LocalDateTime updated_at) {
		this.updatedAt = updated_at;
	}
	
	/**
	 * get the last updater
	 * 
	 * @return LocalDateTime
	 */
	public UserEntity getUpdatedBy() {
		return updatedBy;
	}
	
	/**
	 * set the last updater
	 * 
	 * @return LocalDateTime
	 */
	public void setUpdatedBy(UserEntity updated_by) {
		this.updatedBy = updated_by;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((secret == null) ? 0 : secret.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (secret == null) {
			if (other.secret != null)
				return false;
		} else if (!secret.equals(other.secret))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		return true;
	}

	/**
	 * get the user as string
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", created_at=" + createdAt + ", created_by=" + createdBy + ", updated_at="
				+ updatedAt + ", updated_by=" + updatedBy + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + ", secret=" + secret + "]";
	}
}
