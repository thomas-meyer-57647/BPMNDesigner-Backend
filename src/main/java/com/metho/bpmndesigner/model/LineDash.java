package com.metho.bpmndesigner.model;
import java.util.ArrayList;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;

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

/**
 * a line dash
 * 
 * String name						the name of the linedash (not blank and max 100 chars)
 * List<Integer> segments;			definition of the line dash
 */
public class LineDash {
	
	@NotBlank
    @Size(max=100)	
	private String name;					// the name of the gradient

	@NotNull
	private List<Integer> segments;			// definition of the line dash

	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public LineDash() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param String name						the name of the line dash
	 * @param List<Integer> segments			the segments of the line dash
	 * @throw IllegalArgumentException			- if <code>segments</code> null or has a empty list
	 */
	public LineDash(@NotBlank @Size(max=100)String name, @NotNull List<Integer> segments) {
		super();
		
		if ( segments == null ) {
			throw new IllegalArgumentException("LineDash::constructor(" 
					+ segments + "): Param could not be null");
		}		
		
		this.segments = segments;
	}


	// Getter / Setter
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
	
	/**
	 * get the segments of the line dash
	 * 
	 * @return List<Integer>
	 */
	public List<Integer> getSegments() {
		return segments;
	}

	/**
	 * set the segments of the line dash
	 * 
	 * @param List<Integer> segments
	 * @return null
	 * @throws IllegalArgumentException 		- if the list ist null or empty
	 */
	public void setSegments(@NotNull List<Integer> segments) {
		
		if ( segments == null || segments.size() == 0) {
			throw new IllegalArgumentException("LineDash::setLineDash(" 
					+ segments + "): Param could not be null or empty");
		}		
		
		this.segments = segments;
	}
	
	/**
	 * clone this line dash
	 * 
	 * @return LineDash
	 */
	public LineDash clone()  {
		LineDash lineDash = new LineDash();
		lineDash.name = this.name;
		lineDash.segments = new ArrayList<Integer>();
		
		for (int index=0; index<this.segments.size(); index++) {
			lineDash.segments.add(this.segments.get(index));
		}
		
		return lineDash;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((segments == null) ? 0 : segments.hashCode());
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
		LineDash other = (LineDash) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (segments == null) {
			if (other.segments != null)
				return false;
		} else if (!segments.equals(other.segments))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineDash [name=" + name + ", segments=" + segments + "]";
	}
	
}
