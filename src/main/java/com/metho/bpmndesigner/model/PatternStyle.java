package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * the pattern style
 * 
 * EStyleType type = EStyleType.PATTERN					the pattern style
 *
 */
public class PatternStyle extends Pattern implements IStyle {
	
	private EStyleType type = EStyleType.PATTERN;

	/**
	 * default constructor
	 */
	public PatternStyle() {
		super();
	}
	
	/**
	 * get the pattern style
	 * 
	 * @return EStyleType
	 */
	@Override
	public EStyleType getStyleType() {
		return this.type;
	}

	/**
	 * clone this pattern style
	 * 
	 * @return EStyleType
	 */
	public PatternStyle clone() {
		PatternStyle newPatternStyle = new PatternStyle();
		
		newPatternStyle.setNewFilename( this.getNewFilename() );
		newPatternStyle.setOriginalFilename( this.getOriginalFilename() );
		newPatternStyle.setRepeat( this.getRepeat() );
		newPatternStyle.setMatrix( this.getMatrix().clone() );
		
		return newPatternStyle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatternStyle other = (PatternStyle) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatternStyle [type=" + type + ", getNewFilename()=" + getNewFilename() + ", getOrignalFilename()="
				+ getOriginalFilename() + ", getRepeat()=" + getRepeat() + ", getMatrix()=" + getMatrix() + "]";
	}
	
}
