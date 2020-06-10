package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * a style for a draw object
 * 
 * IStyle fillStyle 					will be only used for closed objects
 * IStyle strokeStyle				 	the style for open objects (e.g. line)
 * LineDash lineDash					solid line dash 
 * ELineCap lineCap						line caps: BUTT
 * int lineWidth						the line width
 * Matrix matrix						the transformation
 */
public class DrawObjectStyle {
	@Field("fill_style")
	private IStyle fillStyle = null; 							     	 	 // will be only used for closed objects

	@Field("stroke_style")
	private IStyle strokeStyle = new ColorStyle(1);				 		 	 // the style for open objects (e.g. line)

	@NotNull
	@Field("line_dash")
	private LineDash lineDash = new LineDash("", new ArrayList<Integer>());  // solid line dash 

	@Field("line_cap")
	private ELineCap lineCap = ELineCap.BUTT;							 	 // line caps: BUTT

	@Field("line_width")
	private int lineWidth = 1;											 	 // the line width
	private Matrix matrix = new Matrix();									 // the transformation

	/**
	 * default constructor
	 */
	public DrawObjectStyle() {
		super();
	}

	/**
	 * Create a draw object style
	 * 
	 * If <code>linewith</code> less than 1 this function throws a
	 * IllegalArgumentException
	 * 
	 * This function throws a RuntimeException if <code>fillStyle</code> or
	 * <code>fillStyle</code> a <code>ColerStyle</code>, <code>GraidentStyle</code>
	 * or <code>PatternStyle</code>. But <code>fillStyle</code> can be null.
	 * <code>strokeStyle</code> can not be a null.
	 * 
	 * if <code>lineDash</code> is null this function throws a NullPointerException
	 * 
	 * NOTE
	 * The constructor create a copy of the <code>fillStyle</code>, <code>strokeStyle</code>,
	 * <code>lineDash</code> and <code>matrix</code>
	 * 
	 * @param fillStyle						will be only used for closed objects		
	 * @param strokeStyle					the style for open objects (e.g. line)
	 * @param lineDash						solid line dash
	 * @param lineCap						line caps: BUTT	
	 * @param lineWidth						the line width
	 * @param matrix						the transformation	
	 * @throws RuntimeException
	 * 		   NullPointerException         
	 * 	 	   IllegalArgumentException
	 */
	public DrawObjectStyle(IStyle fillStyle, IStyle strokeStyle, LineDash lineDash, ELineCap lineCap,
			int lineWidth, Matrix matrix) throws IllegalArgumentException {
		super();
		
		this.setFillStyle(fillStyle);
		this.setStrokeStyle(strokeStyle);
		this.setLineDash(new LineDash(lineDash));
		this.lineCap = lineCap;
		this.setLineWidth(lineWidth);
		this.setMatrix(matrix);
	}
	
	/**
	 * copy construtor
	 * 
	 * This function throws a RuntimeException if <code>fillStyle</code> or
	 * <code>fillStyle</code> a <code>ColerStyle</code>, <code>GraidentStyle</code>
	 * or <code>PatternStyle</code>. But <code>fillStyle</code> can be null.
	 * <code>strokeStyle</code> can not be a null.
	 * 
	 * NOTE
	 * The constructor create a copy of the <code>fillStyle</code>, <code>strokeStyle</code>,
	 * <code>lineDash</code> and <code>matrix</code>
	 * 
	 * @param DrawObjectStyle drawObjectStyle
	 * @throws RuntimeException
	 * 		   NullPointerException         
	 * 	 	   IllegalArgumentException
	 */
	public DrawObjectStyle(DrawObjectStyle drawObjectStyle) {
		this(
			drawObjectStyle.fillStyle,
			drawObjectStyle.strokeStyle,
			drawObjectStyle.lineDash,
			drawObjectStyle.lineCap,
			drawObjectStyle.lineWidth,
			drawObjectStyle.matrix
		);
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
	 * This function throws a RuntimeException if <code>fillStyle</code> is not null or
	 * a <code>ColerStyle</code>, <code>GraidentStyle</code> or <code>PatternStyle</code>
     *
     * NOTE
	 * This function create a copy of fillStyle
	 * 
	 * @oaran ISyle fillStyle
	 * @return void
	 */
	public void setFillStyle(IStyle fillStyle) {
		IStyle newFillStyle = fillStyle;

		if ( fillStyle != null ) {
			if ( fillStyle instanceof ColorStyle ) {
				newFillStyle = new ColorStyle((ColorStyle)fillStyle);
			} else if ( fillStyle instanceof GradientStyle ) {
				newFillStyle = new GradientStyle((GradientStyle)fillStyle);
			} else if ( fillStyle instanceof PatternStyle ) {
				newFillStyle = new PatternStyle((PatternStyle)fillStyle);
			} else {
				throw new RuntimeException("fillstyle is not a color, gradient or pattern!");
			}
		}
		
		this.fillStyle = newFillStyle;
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
	 * This function throws a RuntimeException if <code>strokeStyle</code> is not a
	 * <code>ColerStyle</code>, <code>GraidentStyle</code> or <code>PatternStyle</code>
	 * 
	 * NOTE
	 * This function create a copy of strokeStyle
	 * 
	 * @oaran ISyle strokeStyle				<code>ColerStyle</code>, <code>GraidentStyle</code> or <code>PatternStyle</code>
	 * @return void
	 * @throw RuntimeException  
	 */
	public void setStrokeStyle(IStyle strokeStyle) {
		if ( strokeStyle == null ) {
			throw new IllegalArgumentException("strokestyle could not be null.");
		}
		
		IStyle newStrokeStyle;
		
		if ( strokeStyle instanceof ColorStyle ) {
			newStrokeStyle = new ColorStyle((ColorStyle)strokeStyle);
		} else if ( strokeStyle instanceof GradientStyle ) {
			newStrokeStyle = new GradientStyle((GradientStyle)strokeStyle);
		} else if ( strokeStyle instanceof PatternStyle ) {
			newStrokeStyle = new PatternStyle((PatternStyle)strokeStyle);
		} else {
			throw new RuntimeException("strokestyle is not color, gradient or pattern!");
		}
		
		this.strokeStyle = newStrokeStyle;
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
	 * NOTE
	 * This function create a copy of the <code>lineDash</code>
	 * 
	 * @oaran LineDash fillStyle
	 * @return void
	 * @throws NullPointerException			- if <code>lineDash</code> is null
	 */
	public void setLineDash(LineDash lineDash) {
		this.lineDash = new LineDash(lineDash);
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
	public void setLineWidth(int lineWidth) throws IllegalArgumentException {
		if ( lineWidth < 1 ) {
			throw new IllegalArgumentException("DrawObject::setLineWidth(" + lineWidth + "): The value must be 1 or greater");
		}

		this.lineWidth = lineWidth;
	}

	/**
	 * get the transformation matrix
	 * 
	 * @return Matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}

	/**
	 * set the transformation matrix
	 * 
	 * If <code>matrix</code> null this function will be throw a IllgalArgumentException
	 * 
	 * Note
	 * This function create a copy of the matrix
	 * 
	 * @param matrix
	 * @return void
	 * @throws NullPointerException - if matrix is null
	 */
	public void setMatrix(Matrix matrix) throws IllegalArgumentException {
		this.matrix = new Matrix(matrix);
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fillStyle == null) ? 0 : fillStyle.hashCode());
		result = prime * result + ((lineCap == null) ? 0 : lineCap.hashCode());
		result = prime * result + ((lineDash == null) ? 0 : lineDash.hashCode());
		result = prime * result + lineWidth;
		result = prime * result + ((matrix == null) ? 0 : matrix.hashCode());
		result = prime * result + ((strokeStyle == null) ? 0 : strokeStyle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrawObjectStyle other = (DrawObjectStyle) obj;
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
		if (matrix == null) {
			if (other.matrix != null)
				return false;
		} else if (!matrix.equals(other.matrix))
			return false;
		if (strokeStyle == null) {
			if (other.strokeStyle != null)
				return false;
		} else if (!strokeStyle.equals(other.strokeStyle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DrawObjectStyle [fillStyle=" + fillStyle + ", strokeStyle=" + strokeStyle + ", lineDash=" + lineDash
				+ ", lineCap=" + lineCap + ", lineWidth=" + lineWidth + ", matrix=" + matrix + "]";
	}

}
