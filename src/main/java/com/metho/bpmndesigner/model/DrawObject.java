package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.util.Pair;

/**
 * a draw object
 * 
 * EDrawType drawType;							the draw type
 * String name									the name of the draw object
 * List<Point> points				 			the points of the vector it must be minimal 2 points 
 * IStyle fillStyle 						   	will be only used for closed objects
 * IStyle strokeStyle				 		 	the style for open objects (e.g. line)
 * LineDash lineDash  							solid line dash 
 * ELineCap lineCap							 	line caps: BUTT
 * int lineWidth								the line width
 * String text									text
 * TextDecoration decoration			 		the decoration for the text
 * List<Pair<String, String>> params;			additional information 
 */
public class DrawObject /* extends AbstractDrawObject */ implements AbstractDrawObject {
	private EDrawType drawType;												 // the draw type
	private String name;												 	 // the name of the draw object
	private List<Point> points = new ArrayList<Point>();				 	 // the points of the vector it must be minimal 2 points 
	private IStyle fillStyle = null; 							     	 	 // will be only used for closed objects
	private IStyle strokeStyle = new ColorStyle(1);				 		 	 // the style for open objects (e.g. line)
	private LineDash lineDash = new LineDash("", new ArrayList<Integer>());  // solid line dash 
	private ELineCap lineCap = ELineCap.BUTT;							 	 // line caps: BUTT
	private int lineWidth = 1;											 	 // the line width
	private String text;												 	 // text
	private TextDecoration decoration = new TextDecoration();			 	 // the decoration for the text
	private List<Pair<String, String>> params = new ArrayList<Pair<String, String>>();							 	 // additional information 
	
	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public DrawObject() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * This function throw a IllegalArgumentException if the list 
	 * <code>points</code> is null
	 * 
	 * @param porints
	 * @throw IllegalArgumentException			- if the param is null
	 */
	public DrawObject(List<Point> points) {
		super();
		
		if ( points == null ) {
			throw new IllegalArgumentException("DrawObject::constructor(" + points + "): The value must not be null");
		}
		this.points = points;
	}

	// GETTER / SETTER
	/**
	 * get the draw type of this draw object
	 * 
	 * @return EDrawType
	 */
	public EDrawType getDrawType() {
		return drawType;
	}
	
	/**
	 * set the draw type of this draw object
	 * 
	 * @return EDrawType
	 */
	public void setDrawType(EDrawType drawType) {
		this.drawType = drawType;
	}
	
	/**
	 * get the name of the draw object
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the name of the draw object
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the points of the draw object
	 * 
	 * @return List<Point>
	 */
	public List<Point> getPoints() {
		return points;
	}
	
	/**
	 * set the points of the draw object
	 * 
	 * This function throw a IllegalArgumentException if the list 
	 * <code>points</code> is null
	 * 
	 * @oaran List<Point>
	 * @return void
	 * @throw IllegalArgumentException			- if the param is null
	 */
	public void setPoints(List<Point> points) {
		if ( points == null ) {
			throw new IllegalArgumentException("DrawObject::setPoints(" + points + "): The value must not be null");
		}
		
		this.points = points;
	}
	
	/**
	 * get the fill style of the draw object
	 * 
	 * @return IStyle
	 */
	public IStyle getFillStyle() {
		return fillStyle;
	}
	
	/**
	 * set the fill style of the draw object
	 * 
	 * @oaran ISyle fillStyle
	 * @return void
	 */
	public void setFillStyle(IStyle fillStyle) {
		this.fillStyle = fillStyle;
	}

	/**
	 * get the stroke style of the draw object
	 * 
	 * @return ISyle 
	 */
	public IStyle getStrokeStyle() {
		return strokeStyle;
	}
	
	/**
	 * set the stroke style of the draw object
	 * 
	 * @oaran ISyle strokeStyle
	 * @return void
	 */
	public void setStrokeStyle(IStyle strokeStyle) {
		this.strokeStyle = strokeStyle;
	}
	
	/**
	 * get the linbdash of the draw object
	 * 
	 * @return LineDash
	 */
	public LineDash getLineDash() {
		return lineDash;
	}
	
	/**
	 * set the linedash of the draw object
	 * 
	 * If <code>lineDash</code> null this function throw a 
	 * IllegalArgumentException
	 * 
	 * @oaran LineDash fillStyle
	 * @return void
	 * @throws IllegalArgumentException			- if param is null
	 */
	public void setLineDash(@NotNull LineDash lineDash) {
		if ( lineDash == null ) {
			throw new IllegalArgumentException("DrawObject::setLineDash(" + lineDash + "): The value must not be null");
		}
		
		this.lineDash = lineDash;
	}
	
	/**
	 * set the line cap of the draw object
	 * 
	 * @return ELineCap
	 */
	public ELineCap getLineCap() {
		return lineCap;
	}
	
	/**
	 * set the line cap of the draw object
	 * 
	 * @oaran ISyle fillStyle
	 * @return void
	 */
	public void setLineCap(ELineCap lineCap) {
		this.lineCap = lineCap;
	}
	
	/**
	 * get the line with of the draw object
	 * 
	 * @return int
	 */
	public int getLineWidth() {
		return lineWidth;
	}
	
	/**
	 * set the line with of the draw object
	 * 
	 * If <code>linewith</code> less than 1 this function throws a
	 * IllegalArgumentException
	 * 
	 * @param int linewith
	 * @return void
	 * @throws IllegalArgumentTexception		- if param less than 1
	 */
	public void setLineWidth(int lineWidth) {
		if ( lineWidth < 1 ) {
			throw new IllegalArgumentException("DrawObject::setLineWidth(" + lineWidth + "): The value must be 1 or greater");
		}

		this.lineWidth = lineWidth;
	}
	
	/**
	 * get the text of the draw object
	 * 
	 * @return String
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * set the text of the draw object
	 * 
	 * @param String
	 * @return
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * get the text decoration of the draw object
	 * 
	 * @return TextDecoration
	 */
	public TextDecoration getDecoration() {
		return decoration;
	}
	
	/**
	 * set the text decoration of the draw object
	 * 
	 * If <code>decoration</code> null this function throws a 
	 * IllegalArgumentException
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 * @throws IllegalArgumentException		- if param is null
	 */
	public void setDecoration(TextDecoration decoration) {
		if ( decoration == null ) {
			throw new IllegalArgumentException("DrawObject::setDecoration(" + decoration + "): The value must be not null");
		}

		this.decoration = decoration;
	}
	
	/**
	 * get additonal information of the draw object
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 */
	public List<Pair<String, String>> getParams() {
		return params;
	}
	
	/**
	 * set additonal information of the draw object
	 * 
	 * If <code>params</code> is null this function throws a 
	 * IllegalArgumentException
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 * @throws IllegalArgumentException			- if param is null
	 */
	public void setParams(List<Pair<String, String>> params) {
		if ( params == null ) {
			throw new IllegalArgumentException("DrawObject::setParams(" + params + "): The value must be not null");
		}
		
		this.params = params;
	}

	/**
	 * clone this draw object
	 * 
	 * @return DrawObject
	 */
	public DrawObject clone() {
		DrawObject newDrawObject = new DrawObject();

		newDrawObject.drawType = this.drawType;
		newDrawObject.name = this.name;
		
		for (int index=0; index<this.params.size(); index++) {
			newDrawObject.getPoints().add(this.points.get(index));
		}
		
		newDrawObject.decoration = this.decoration.clone();
		newDrawObject.fillStyle = (this.fillStyle == null) ? null : this.fillStyle.clone();
		newDrawObject.strokeStyle = (this.strokeStyle == null) ? null : this.strokeStyle.clone();
		newDrawObject.lineDash = this.lineDash.clone();
		newDrawObject.lineCap = this.lineCap;
		newDrawObject.lineWidth = this.lineWidth;
		newDrawObject.text = this.text;
		newDrawObject.params = new ArrayList<Pair<String, String>>();
		
		for (int index=0; index<this.params.size(); index++) {
			Pair<String, String> pair = Pair.of(
					this.params.get(index).getFirst(), 
					this.params.get(index).getSecond()
			);
			
			newDrawObject.params.add(pair);
		}
		
		return newDrawObject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((decoration == null) ? 0 : decoration.hashCode());
		result = prime * result + ((drawType == null) ? 0 : drawType.hashCode());
		result = prime * result + ((fillStyle == null) ? 0 : fillStyle.hashCode());
		result = prime * result + ((lineCap == null) ? 0 : lineCap.hashCode());
		result = prime * result + ((lineDash == null) ? 0 : lineDash.hashCode());
		result = prime * result + lineWidth;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((strokeStyle == null) ? 0 : strokeStyle.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
	//	if (!super.equals(obj))
	//		return false;
		if (getClass() != obj.getClass())
			return false;
		DrawObject other = (DrawObject) obj;
		if (decoration == null) {
			if (other.decoration != null)
				return false;
		} else if (!decoration.equals(other.decoration))
			return false;
		if (drawType != other.drawType)
			return false;
		if (fillStyle == null) {
			if (other.fillStyle != null)
				return false;
		} else if (!fillStyle.equals(other.fillStyle))
			return false;
		if (lineCap != other.lineCap)
			return false;
		if (lineDash == null) {
			if (other.lineDash != null)
				return false;
		} else if (!lineDash.equals(other.lineDash))
			return false;
		if (lineWidth != other.lineWidth)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (strokeStyle == null) {
			if (other.strokeStyle != null)
				return false;
		} else if (!strokeStyle.equals(other.strokeStyle))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DrawObject [drawType=" + drawType + ", name=" + name + ", points=" + points + ", fillStyle=" + fillStyle
				+ ", strokeStyle=" + strokeStyle + ", lineDash=" + lineDash + ", lineCap=" + lineCap + ", lineWidth="
				+ lineWidth + ", text=" + text + ", decoration=" + decoration + ", params=" + params + "]";
	}
	

}
