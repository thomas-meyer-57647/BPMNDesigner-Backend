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
 * this is the gradient for a fill style
 */
public class GradientStyle extends Gradient implements IStyle {
	
	private EStyleType type = EStyleType.GRADIENT;
	
	/**
	 * default constructor
	 */
	public GradientStyle() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param type								LINEARGRADIENT | RADIALGRADIENT 
	 * @param name
	 * @param idname
	 * @param x1
	 * @param y1
	 * @param r1
	 * @param x2
	 * @param y2
	 * @param r2
	 * @param colorstops
	 */
	public GradientStyle(EGradientType type, String name, String idname, int x1, int y1, int r1, int x2, int y2,
			int r2, @NotNull List<ColorStop> colorstops) {
		super(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
	}

	/**
	 * copy constructor
	 * 
	 * @param GradientStyle gradientStyle
	 */
	public GradientStyle(GradientStyle gradientStyle) {
		super(gradientStyle);
	}

	// GETTER / SETTER
	/**
	 * get the type of fill style
	 * 
	 * @return EStyleType
	 */
	@Override
	public EStyleType getStyleType() {
		return type;
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
		GradientStyle other = (GradientStyle) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GradientStyle [type=" + type + ", getGradientType()=" + getGradientType() + ", getName()=" + getName()
				+ ", getIdname()=" + getIdname() + ", getX1()=" + getX1() + ", getY1()=" + getY1() + ", getR1()="
				+ getR1() + ", getX2()=" + getX2() + ", getY2()=" + getY2() + ", getR2()=" + getR2()
				+ ", getColorStops()=" + getColorStops() + "]";
	}


}
