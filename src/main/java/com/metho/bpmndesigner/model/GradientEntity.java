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
import org.springframework.data.mongodb.core.mapping.DBRef;import org.springframework.data.mongodb.core.mapping.Document;

/**
 * this is a storable gradient
 */
@Document(collection="gradients")
public class GradientEntity extends Gradient implements IStoreable {
	
	@Id
	private int id;										// the id of the collection
	private LocalDateTime created_at;					// the created date
	
	@DBRef
	private UserEntity created_by;						// the creator
	
	private LocalDateTime updated_at;					// the last update date
	
	@DBRef
	private UserEntity updated_by;						// the updater

	/**
	 * get id of the palette
	 * 
	 * @return int
	 * @public
	 */
	public int getId() {
		return id;
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

}
