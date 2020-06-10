package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * this is the interface for all textable draw objects
 * 
 */
public interface ITextable {
	String getText();
	void setText(String text);
	TextDecoration getTextDecoration();
	void setTextDecoration(TextDecoration textDecoration);
	Point getTextPosition();
	void setTextPosition(Point point);
}
