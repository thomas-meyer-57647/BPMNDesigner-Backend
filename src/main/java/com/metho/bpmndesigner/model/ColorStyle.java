package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * this is a color for the fill style
 */
public class ColorStyle extends Color implements IStyle {

	private EStyleType type = EStyleType.COLOR;

	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 * @param transparency
	 * @param name
	 */
	public ColorStyle(@Min(0) int colorvalue, @Min(0) @Max(1) Float transparency, String name) {
		super(colorvalue, transparency, name);
	}

	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 * @param transparency
	 */
	public ColorStyle(@Min(0) int colorvalue, @Min(0) @Max(1) Float transparency) {
		super(colorvalue, transparency);
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 */
	public ColorStyle(@Min(0) int colorvalue) {
		super(colorvalue);
	}

	// Getter
	@Override
	public EStyleType getStyleType() {
		return type;
	}

}
