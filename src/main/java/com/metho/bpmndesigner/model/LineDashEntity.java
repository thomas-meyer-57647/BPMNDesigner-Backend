package com.metho.bpmndesigner.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

/**
 * this is a storable linedash
 */
@Document(collection="linedashes")
public class LineDashEntity extends LineDash implements IStoreable {

	@Transient
    public static final String SEQUENCE_NAME = "linedash_sequence";
	
	@Id
	private int id;										// the id of the collection
	private LocalDateTime created_at;					// the created date
	
	@DBRef
	private UserEntity created_by;						// the creator
	
	private LocalDateTime updated_at;					// the last update date
	
	@DBRef
	private UserEntity updated_by;						// the updater
	
	@Indexed
	@NotBlank
    @Size(max=100)	
	private String name;								// the name of the palette
		
	/**
	 * the initialize constructor
	 */
	public LineDashEntity(@NotNull List<Integer> segments) {
		super(segments);
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

}
