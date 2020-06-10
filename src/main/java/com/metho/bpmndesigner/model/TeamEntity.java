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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
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
@CompoundIndexes({
    @CompoundIndex(name = "user_teams", def = "{'createdBy.id' : 1, 'name': 1}, {unique: true}")
})
public class TeamEntity {
	
	@Transient
    public static final String SEQUENCE_NAME = "team_sequence";
	
	@Id
	private long id;									// the id of the team collection
	
	@Field("created_at")	
	private LocalDateTime createdAt;					// the created date
	
	@DBRef
	@Field("created_by")
	private UserEntity createdBy;						// the creator
	
	@Field("updated_at")
	private LocalDateTime updatedAt;					// the last update date
	
	@DBRef
	@Field("updated_by")	
	private UserEntity updatedBy;						// the updater
	
	@NotBlank
    @Size(max=100)
	private String name;								// name of the team
	
	@DBRef
	List<UserEntity> users;								// the users who work together. Contains 1 or more user
	
	@DBRef
	List<DocumentEntity> documents;						// the documents which the team use. Contains 1 or more documents

	/**
	 * default constructor
	 */
	public TeamEntity() {
		super();
	}
	
	/**
	 * intialize constructor
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((documents == null) ? 0 : documents.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		TeamEntity other = (TeamEntity) obj;
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
		if (documents == null) {
			if (other.documents != null)
				return false;
		} else if (!documents.equals(other.documents))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeamEntity [id=" + id + ", created_at=" + createdAt + ", created_by=" + createdBy + ", updated_at="
				+ updatedAt + ", updated_by=" + updatedBy + ", name=" + name + ", users=" + users + ", documents="
				+ documents + ", getId()=" + getId() + ", getCreatedAt()=" + getCreatedAt() + ", getCreatedBy()="
				+ getCreatedBy() + ", getUpdatedAt()=" + getUpdatedAt() + ", getUpdatedBy()=" + getUpdatedBy()
				+ ", getName()=" + getName() + ", getUsers()=" + getUsers() + ", getDocuments()=" + getDocuments()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
