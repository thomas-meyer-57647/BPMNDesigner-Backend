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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * this is a storable gradient
 * 
 * int id												the id of the document
 * LocalDateTime createdAt								the created date
 * UserEntity createdBy									the creator
 * LocalDateTime updatedAt								the last update date
 * UserEntity updatedBy									the updater
 */
@Document(collection="gradients")
@CompoundIndexes({
    @CompoundIndex(name = "user_gradients", def = "{'createdBy.id' : 1, 'name': 1}, {unique: true}")
})
public class GradientEntity extends Gradient implements IStoreable {
	
	@Transient
    public static final String SEQUENCE_NAME = "gradient_sequence";
	
	@Id
	private long id;									// the id of the collection
	
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
	
	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public GradientEntity() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param gradienttype				(inherited) the gradienttype
	 * @param name						the name of the gradient
	 * @param idname					(inherited) the id name
	 * @param x1						(inherited) the start position x
	 * @param y1						(inherited) the start position y
	 * @param r1						(inherited) the radius 1 (only radial gradient)
	 * @param x2						(inherited) the end position x
	 * @param y2						(inherited) the end position y
	 * @param r2						(inherited) the radius 1 (only radial gradient)
	 * @param colorstops				(inherited) the colorstops
	 */
	public GradientEntity(EGradientType gradienttype, String name, String idname, int x1, int y1, int r1, int x2, int y2, int r2,
			@NotNull List<ColorStop> colorstops) {
		super(gradienttype, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
	}

	/**
	 * get id of the palette
	 * 
	 * @return long
	 * @public
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set id of the palette
	 * 
	 * @param long
	 * @return void
	 * @public
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

	@Override
	public String toString() {
		return "GradientEntity [id=" + id + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt="
				+ updatedAt + ", updatedBy=" + updatedBy + ", getGradientType()=" + getGradientType() + ", getIdname()="
				+ getIdname() + ", getX1()=" + getX1() + ", getY1()=" + getY1() + ", getR1()=" + getR1() + ", getX2()="
				+ getX2() + ", getY2()=" + getY2() + ", getR2()=" + getR2() + ", getColorStops()=" + getColorStops()
				+ "]";
	}


}
