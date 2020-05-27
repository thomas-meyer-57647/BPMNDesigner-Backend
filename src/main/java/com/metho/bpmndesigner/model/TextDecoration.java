package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * this is the text decoration for a <code>DrawObject</code>
 */
public class TextDecoration {
	private Matrix matrix = new Matrix();
	private String font = "10px sans-serif";
	private ETextAlign align = ETextAlign.START;
	private ETextBaseline baseline = ETextBaseline.ALPHABETIC;
	private ETextDirection direction = ETextDirection.INHERIT;
	
	/**
	 * default constructor
	 */
	public TextDecoration() {
		super();
	}

	// GETTER / SETTER
	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public ETextAlign getAlign() {
		return align;
	}

	public void setAlign(ETextAlign align) {
		this.align = align;
	}

	public ETextBaseline getBaseline() {
		return baseline;
	}

	public void setBaseline(ETextBaseline baseline) {
		this.baseline = baseline;
	}

	public ETextDirection getDirection() {
		return direction;
	}

	public void setDirection(ETextDirection direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "TextDecoration [matrix=" + matrix + ", font=" + font + ", align=" + align + ", baseline=" + baseline
				+ ", direction=" + direction + "]";
	}
}
