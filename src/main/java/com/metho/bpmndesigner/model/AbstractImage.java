package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this is the abstract class for <code>Pattern</code> and <code>Image</code>
 * 
 * String newFilename					the filename on the server
 * String originalFilename;				the original filename 
 * Matrix matrix						the matrix for the transformation of the pattern
 */
public class AbstractImage {
	
	@Field("new_filename")
	private String newFilename;							// the filename on the server
	
	@Field("org_filename")
	private String originalFilename;					// the original filename 

	@NotNull
	private Matrix matrix = new Matrix();				// the matrix for the transformation of the pattern

	/**
	 * default constructor
	 */
	public AbstractImage() {
		super();
	}

	/**
	 * initialize constructor
	 * 
	 * if <code>matrix</code> is null this function throw an NullPointerException
     *
	 * @param newFilename
	 * @param originalFilename
	 * @param matrix
	 * @throw NullPointerException
	 */
	public AbstractImage(String newFilename, String originalFilename, Matrix matrix) {
		super();

		this.newFilename = newFilename;
		this.originalFilename = originalFilename;
		this.matrix = new Matrix(matrix);
	}
	
	/**
	 * copy constructor
	 * 
	 * @param AbstractImage abstractImage
	 * @throw NullPointerException
	 */
	public AbstractImage(AbstractImage abstractImage) {
		this(
			abstractImage.newFilename,
			abstractImage.originalFilename,
			abstractImage.matrix
		);
	}

	/**
	 * get the new filename
	 * 
	 * @return String
	 */
	public String getNewFilename() {
		return newFilename;
	}

	/**
	 * set the new filename 
	 * 
	 * @param newFilename
	 * @return void
	 */
	public void setNewFilename(String newFilename) {
		this.newFilename = newFilename;
	}

	/**
	 * get the original filename
	 * 
	 * @return String
	 */
	public String getOriginalFilename() {
		return originalFilename;
	}

	/**
	 * set the original filename
	 * 
	 * @param String originalFilename
	 * @return void
	 */
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	/**
	 * get the transformation matrix
	 * 
	 * @return Matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}
	
	/**
	 * set the transformation matrix
	 * 
	 * if <code>matrix</code> is null this function throw an NullPointerException
	 * 
	 * Note
	 * This function create a copy of the given <code>matrix</code>
	 * 
	 * @return Matrix
	 * @throw NullPointerException
	 */
	public void setMatrix(Matrix matrix) {
		this.matrix = new Matrix(matrix);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matrix == null) ? 0 : matrix.hashCode());
		result = prime * result + ((newFilename == null) ? 0 : newFilename.hashCode());
		result = prime * result + ((originalFilename == null) ? 0 : originalFilename.hashCode());
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
		AbstractImage other = (AbstractImage) obj;
		if (matrix == null) {
			if (other.matrix != null)
				return false;
		} else if (!matrix.equals(other.matrix))
			return false;
		if (newFilename == null) {
			if (other.newFilename != null)
				return false;
		} else if (!newFilename.equals(other.newFilename))
			return false;
		if (originalFilename == null) {
			if (other.originalFilename != null)
				return false;
		} else if (!originalFilename.equals(other.originalFilename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractImage [newFilename=" + newFilename + ", originalFilename=" + originalFilename + ", matrix="
				+ matrix + "]";
	}
}
