package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * a team is a group of person, how works on one or more dokuments
 * 
 * Integer id;										the id of the team collection
 * LocalDateTime created_at							the created date
 * UserEntity created_by							the creator
 * LocalDateTime updated_at							the last update date
 * UserEntity updated_by							the updater
 * String name;										name of the team
 * List<UserEntity> users							the users who work together. Contains 1 or more user
 * List<DocumentEntity> users						the documents who edit by the team member. Contains 1 or more user
 */
@Document(collection="teams")
public class TeamEntity implements IStoreable {
	
	@Transient
    public static final String SEQUENCE_NAME = "team_sequence";
	
	@Id
	private long id;									// the id of the team collection
	private LocalDateTime created_at;					// the created date
	
	@DBRef
	private UserEntity created_by;						// the creator
	
	private LocalDateTime updated_at;					// the last update date
	
	@DBRef
	private UserEntity updated_by;						// the updater
	
	@Indexed
	private String name;								// name of the team
	
	@DBRef
	List<UserEntity> users;								// the users who work together. Contains 1 or more user
	
	@DBRef
	List<DocumentEntity> documents;						// the documents which the team use. Contains 1 or more documents

	/**
	 * default constructor
	 * 
	 * if <code>users</code> or <code>documents</code> null or empty list this function
	 * throw a IllegalArgumentException
	 * 
	 * @param List<UserEntity> users						the user in the team
	 * @param List<DocumentEntity> documents				the documents of the team
	 * @return void
	 * @throws IllegalArgumentException
	 */
	public TeamEntity(List<UserEntity> users, List<DocumentEntity> documents) throws IllegalArgumentException {
		super();
		
		if ( users == null ) {
			throw new IllegalArgumentException("TeamEntity::constructor(" + users + ", " + documents + "): users could not be null");
		}
		
		if ( documents == null ) {
			throw new IllegalArgumentException("TeamEntity::constructor(" + users + ", " + documents + "): documents could not be null");
		}
		
		if ( users.size() == 0 ) {
			throw new IllegalArgumentException("TeamEntity::constructor(" + users + ", " + documents + "): users list must contain one or more users");
		}
		
		if ( documents.size() == 0 ) {
			throw new IllegalArgumentException("TeamEntity::constructor(" + users + ", " + documents + "): documents list must contain one or more document");
		}

		this.users = users;
		this.documents = documents;
	}

	// GETTER / SETTER
	/**
	 * get the id of the team
	 * 
	 * @return Integer
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set the id of the team
	 * 
	 * @param Integer
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
	public UserEntity getCreatedBy() {
		return created_by;
	}
	
	/**
	 * set the first creator
	 * 
	 * @param UserEntity
	 * @return void
	 */
	public void setCreatedBy(UserEntity created_by) {
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
	public UserEntity getUpdatedBy() {
		return updated_by;
	}
	
	/**
	 * set the last updater
	 * 
	 * @return LocalDateTime
	 */
	public void setUpdatedBy(UserEntity updated_by) {
		this.updated_by = updated_by;
	}
	
	/**
	 * get the name of the team
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the team
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the users who works together
	 * 
	 * @return List<User>
	 */
	public List<UserEntity> getUsers() {
		return users;
	}
	
	/**
	 * set the users who works together
	 * 
	 * if <code>users</code> null or the list contains 0 users this function will be 
	 * throw a IllegalArgumentException
	 * 
	 * @param List<User>
	 * @return void
	 * @throws IllegalArgumentException
	 */
	public void setUsers(List<UserEntity> users) throws IllegalArgumentException {
		if (users == null || users.size() == 0) {
			throw new IllegalArgumentException("TeamEntity::setUsers(" + users + "): could not be null or empty list");
		}
		
		this.users = users;
	}
	
	/**
	 * get the documents of the team
	 * 
	 * @param List<User>
	 * @return void
	 * @throws IllegalArgumentException
	 */
	public List<DocumentEntity> getDocuments() {
		return documents;
	}
	
	/**
	 * set the documents of the team
	 * 
	 * if <code>documents</code> null or the list contains 0 documents this function
	 * will be throw a IllegalArgumentException
	 * 
	 * @param List<User>
	 * @return void
	 * @throws IllegalArgumentException
	 */
	public void setDocuments(List<DocumentEntity> documents) {
		if (documents == null || documents.size() == 0) {
			throw new IllegalArgumentException("TeamEntity::setDocuments(" + documents + "): could not be null or empty list");
		}

		this.documents = documents;
	}

	@Override
	public String toString() {
		return "TeamEntity [id=" + id + ", created_at=" + created_at + ", created_by=" + created_by + ", updated_at="
				+ updated_at + ", updated_by=" + updated_by + ", name=" + name + ", users=" + users + ", documents="
				+ documents + ", getId()=" + getId() + ", getCreatedAt()=" + getCreatedAt() + ", getCreatedBy()="
				+ getCreatedBy() + ", getUpdatedAt()=" + getUpdatedAt() + ", getUpdatedBy()=" + getUpdatedBy()
				+ ", getName()=" + getName() + ", getUsers()=" + getUsers() + ", getDocuments()=" + getDocuments()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
