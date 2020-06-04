package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this is a pattern which was used in <code>PatternFillStyle</code> for a fillStyle
 * or Stroke Style
 * 
 * String newFilename;							the filename on the server
 * String orignalFilename						the original filename  
 * EPatternRepeat repeat						the repeat for the PatternStyle
 * Matrix matrix								the matrix for the transformation of the pattern
 */
public class Pattern {
	
	@Field("new_filename")
	private String newFilename;							// the filename on the server
	
	@Field("org_filename")
	private String originalFilename;						// the original filename 
	private EPatternRepeat repeat;						// the repeat for the PatternStyle
	private Matrix matrix;								// the matrix for the transformation of the pattern
	
	/**
	 * default constructor
	 */
	public Pattern() {
		super();
	}

	// Getter / Setter
	/**
	 * get the filename on the server
	 * 
	 * @return String
	 */
	public String getNewFilename() {
		return newFilename;
	}
	
	/**
	 * set the filename on the server
	 * 
	 * @param String
	 * @return void
	 */
	public void setNewFilename(String newfilename) {
		this.newFilename = newfilename;
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
	 * @param String
	 * @return void
	 */
	public void setOriginalFilename(String orignalFilename) {
		this.originalFilename = orignalFilename;
	}
	
	/**
	 * get the repeating of the pattern
	 * 
	 * @return EPatternRepeat
	 */
	public EPatternRepeat getRepeat() {
		return repeat;
	}
	
	/**
	 * set the repeating of the pattern
	 * 
	 * @param EPatternRepeat
	 * @return void
	 */
	public void setRepeat(EPatternRepeat repeat) {
		this.repeat = repeat;
	}
	
	/**
	 * get the transformation matrix of the pattern
	 * 
	 * @return Matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}
	
	/**
	 * set the transformation matrix of the pattern
	 * 
	 * @return Matrix
	 */
	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * clone this pattern
	 * 
	 * @return Pattern
	 */
	public Pattern clone() {
		Pattern newPattern = new Pattern();
		
		newPattern.newFilename = this.newFilename;
		newPattern.originalFilename = this.originalFilename;
		newPattern.repeat = this.repeat;
		newPattern.matrix = this.matrix.clone();
		
		return newPattern;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matrix == null) ? 0 : matrix.hashCode());
		result = prime * result + ((newFilename == null) ? 0 : newFilename.hashCode());
		result = prime * result + ((originalFilename == null) ? 0 : originalFilename.hashCode());
		result = prime * result + ((repeat == null) ? 0 : repeat.hashCode());
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
		Pattern other = (Pattern) obj;
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
		if (repeat != other.repeat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pattern [newfilename=" + newFilename + ", orignalFilename=" + originalFilename + ", repeat=" + repeat
				+ ", matrix=" + matrix + "]";
	}
	
}
