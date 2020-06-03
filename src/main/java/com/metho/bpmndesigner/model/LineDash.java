package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * a line dash
 * 
 * List<Integer> segments;			definition of the line dash
 */
public class LineDash {
	
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
	 * @param linedash			the line dash
	 */
	public LineDash(@NotNull List<Integer> segments) {
		super();
		
		if ( segments == null ) {
			throw new IllegalArgumentException("LineDash::constructor(" 
					+ segments + "): Param could not be null or empty");
		}		
		
		this.segments = segments;
	}


	// Getter / Setter
	
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
	
	
}
