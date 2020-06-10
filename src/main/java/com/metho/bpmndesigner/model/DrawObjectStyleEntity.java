package com.metho.bpmndesigner.model;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * store object for a draw object style  
 * 
 * long id											the id of the document
 * LocalDateTime createdAt							the created date
 * UserEntity createdBy								the creator
 * LocalDateTime updatedAt							the last update date
 * UserEntity updatedBy								the updater
 * String name;										the name of the draw object style
 */
@Document(collection="drawobjectstyle")
@CompoundIndexes({
    @CompoundIndex(name = "user_drawobjectstyle", def = "{'createdBy.id' : 1, 'name': 1}, {unique: true}")
})
public class DrawObjectStyleEntity extends DrawObjectStyle {
	
	@Transient
    public static final String SEQUENCE_NAME = "drawobjectstyle_sequence";
	
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

	@NotBlank
    @Size(max=100)	
	private String name;							// the name of the gradient
	
	/**
	 * default constructor
	 */
	public DrawObjectStyleEntity() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param fillStyle
	 * @param strokeStyle
	 * @param lineDash
	 * @param lineCap
	 * @param lineWidth
	 * @param matrix
	 * @throws IllegalArgumentException
	 */
	public DrawObjectStyleEntity(IStyle fillStyle, @NotNull IStyle strokeStyle, @NotNull LineDash lineDash,
			ELineCap lineCap, int lineWidth, @NotNull Matrix matrix) throws IllegalArgumentException {
		super(fillStyle, strokeStyle, lineDash, lineCap, lineWidth, matrix);
	}

	/**
	 * copy constructor
	 * 
	 * @param drawObjectStyle
	 */
	public DrawObjectStyleEntity(DrawObjectStyle drawObjectStyle) {
		super(drawObjectStyle);
	}


	/**
	 * get the id of the draw object style
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set the id of the draw object style
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
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
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
	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
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
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
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
	public void setUpdatedBy(UserEntity updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	/**
	 * get the name of the style
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the style
	 * 
	 * @param String
	 * @void
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrawObjectStyleEntity other = (DrawObjectStyleEntity) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "DrawObjectStyleEntity [id=" + id + ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + ", name=" + name + ", getFillStyle()="
				+ getFillStyle() + ", getStrokeStyle()=" + getStrokeStyle() + ", getLineDash()=" + getLineDash()
				+ ", getLineCap()=" + getLineCap() + ", getLineWidth()=" + getLineWidth() + ", getMatrix()="
				+ getMatrix() + "]";
	}


}
