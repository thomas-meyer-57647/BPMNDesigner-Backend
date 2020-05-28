package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * a user 
 */
@Document(collection="users")
public class User implements IStoreable {
	
	/**
	 * the id of the collection
	 */
	@Id
	private int id;
	
	/**
	 * the created date
	 */
	private LocalDateTime created_at;
	
	/**
	 * the creater
	 */
	private User created_by;
	
	/**
	 * the last update date
	 */
	private LocalDateTime updated_at;
	
	/**
	 * the updater
	 */
	private User updated_by;


	/**
	 * default constructor 
	 */
	public User() {
		super();
	}

	// GETTER / SETTER
	public LocalDateTime getCreatedAt() {
		return created_at;
	}


	public void setCreatedAt(LocalDateTime created_at) {
		this.created_at = created_at;
	}


	public User getCreatedBy() {
		return created_by;
	}


	public void setCreatedBy(User created_by) {
		this.created_by = created_by;
	}


	public LocalDateTime getUpdatedAt() {
		return updated_at;
	}


	public void setUpdatedAt(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}


	public User getUpdatedBy() {
		return updated_by;
	}


	public void setUpdatedBy(User updated_by) {
		this.updated_by = updated_by;
	}
	
	
}
