package com.metho.bpmndesigner.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this is a storable linedash
 * 
 * int id										the id of the collection
 * LocalDateTime createdAt						the created at
 * UserEntity createdBy							the creator
 * LocalDateTime updatedAt						the last update date
 * UserEntity updatedBy							the updater
 * String name									the name of the linedash (not blank and max 100 chars)
 */
@Document(collection="linedashes")
@CompoundIndexes({
    @CompoundIndex(name = "user_linedashes", def = "{'createdBy.id' : 1, 'name': 1}, {unique: true}")
})
public class LineDashEntity extends LineDash implements IStoreable {

	@Transient
    public static final String SEQUENCE_NAME = "linedash_sequence";
	
	@Id
	private long id;										// the id of the collection
	
	@Field("created_at")
	private LocalDateTime createdAt;					// the created date
	
	@DBRef
	@Field("created_by")
	private UserEntity createdBy;						// the creator
	
	@Field("updated_at")	
	private LocalDateTime updatedAt;					// the last update date
	
	@DBRef
	@Field("udated_by")	
	private UserEntity updatedBy;						// the updater
	
	@Indexed
	@NotBlank
    @Size(max=100)	
	private String name;								// the name of the gradient
	
		
	/**
	 * the initialize constructor
	 */
	public LineDashEntity(String name, @NotNull List<Integer> segments) {
		super(segments);
		
		this.name = name;
	}
	
	/**
	 * get the id of the linedash
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set the id of the linedash
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
	 * get the name of the gradient
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the gradient
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LineDashEntity [id=" + id + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt="
				+ updatedAt + ", updatedBy=" + updatedBy + ", name=" + name + ", getSegments()=" + getSegments() + "]";
	}

}
