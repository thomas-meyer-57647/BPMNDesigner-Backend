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
 */
public class LineDash {
	/**
	 * definition of the line dash
	 */
	@NotNull
	private List<Integer> segments;

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
	public List<Integer> getSegments() {
		return segments;
	}

	public void setSegments(@NotNull List<Integer> segments) {
		
		if ( segments == null ) {
			throw new IllegalArgumentException("LineDash::setLineDash(" 
					+ segments + "): Param could not be null or empty");
		}		
		
		this.segments = segments;
	}
	
	
}
