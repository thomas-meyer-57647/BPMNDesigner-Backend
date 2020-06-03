package com.metho.bpmndesigner.model;
import javax.validation.constraints.NotBlank;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import javax.validation.constraints.NotNull;

/**
 * this is the text decoration for a <code>DrawObject</code>
 * 
 * Matrix matrix								the transformation matrix
 * String font									the font familie
 * ETextAlign align								the horizontal alignment of the text
 * ETextBaseline baseline						the vertical alignment of the text
 * ETextDirection direction						the read direction of the text

 */
public class TextDecoration {
	@NotNull
	private Matrix matrix = new Matrix();							// the transformation matrix
	
	@NotBlank
	private String font = "10px sans-serif";						// the font familie
	private ETextAlign align = ETextAlign.START;					// the horizontal alignment of the text
	private ETextBaseline baseline = ETextBaseline.ALPHABETIC;		// the vertical alignment of the text
	private ETextDirection direction = ETextDirection.INHERIT;		// the read direction of the text
	
	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public TextDecoration() {
		super();
	}

	// GETTER / SETTER
	/**
	 * get the matrix of the text decoration
	 * 
	 * @return Matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}
	
	/**
	 * set the matrix of the text decoration
	 * The Matrix could not be null
	 * 
	 * @param Matrix
	 * @return void
	 */
	public void setMatrix(@NotNull Matrix matrix) {
		this.matrix = matrix;
	}
	
    /**
     * get the font familiy
     * 
     * @return String
     */
	public String getFont() {
		return font;
	}
	
    /**
     * set the font familiy
     * 
     * The <code>font</code> can not be blank
     * 
     * @param String
     */
	public void setFont(@NotBlank String font) {
		this.font = font;
	}

	/**
	 * get the horizontal alignment of the text
	 * 
	 * @return ETextAlign
	 */
	public ETextAlign getAlign() {
		return align;
	}
	
	/**
	 * set the horizontal alignment of the text
	 * 
	 * @param ETextAlign
	 * @return void
	 */
	public void setAlign(ETextAlign align) {
		this.align = align;
	}
	
	/**
	 * get the vertical alignment of the text
	 * 
	 * @return ETextBaseline
	 */
	public ETextBaseline getBaseline() {
		return baseline;
	}
	
	/**
	 * set the vertical alignment of the text
	 * 
	 * @param ETextBaseline
	 * @return void
	 */
	public void setBaseline(ETextBaseline baseline) {
		this.baseline = baseline;
	}
	
	/**
	 * get the read direction
	 * 
	 * @return ETextDirection
	 */
	public ETextDirection getDirection() {
		return direction;
	}
	
	/**
	 * set the vertical alignment of the text
	 * 
	 * @param ETextBaseline
	 * @return void
	 */
	public void setDirection(ETextDirection direction) {
		this.direction = direction;
	}
	
	/**
	 * clone this text decoration
	 * 
	 * @return TextDecoration
	 */
	public TextDecoration clone() {
		TextDecoration newTextDecoration = new TextDecoration();
		
		newTextDecoration.matrix = this.matrix.clone();
		newTextDecoration.font = this.font;
		newTextDecoration.align = this.align;
		newTextDecoration.baseline = this.baseline;
		newTextDecoration.direction = this.direction;
		
		return newTextDecoration;
	}

	@Override
	public String toString() {
		return "TextDecoration [matrix=" + matrix + ", font=" + font + ", align=" + align + ", baseline=" + baseline
				+ ", direction=" + direction + "]";
	}
}
