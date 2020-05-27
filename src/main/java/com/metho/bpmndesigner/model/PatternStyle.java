package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

public class PatternStyle extends Pattern implements IStyle {
	
	private EStyleType type = EStyleType.PATTERN;

	@Override
	public EStyleType getStyleType() {
		return this.type;
	}
	
}
