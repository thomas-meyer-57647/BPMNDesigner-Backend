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

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * an abstract draw object
 * 
 * EDrawType drawType						the draw type
 * List<Point> points						the points for the draw object
 * DrawObjectStyle drawObjectStyle			the draw object style
 */
public class AbstractDrawObject {
		@Field("draw_type")
		private EDrawType drawType = EDrawType.LINE;							// the draw type

		private List<Point> points = new ArrayList<Point>();					// the points for the draw object

		@Field("draw_style")
		private DrawObjectStyle drawObjectStyle = new DrawObjectStyle();		// the draw object style

		/**
		 * default constructor
		 */
		public AbstractDrawObject() {
			super();
		}

		/**
		 * initialize constructor
		 * 
		 * If <code>points</code>  or <code>drawObjectStyle</code> is null this 
		 * function throws a NullPointerException
		 * 
		 * @param EDrawType drawType
		 * @param List<Point> points
		 * @param DrawObjectStyle drawObjectStyle
		 * @throws NullPointerException
		 */
		public AbstractDrawObject(EDrawType drawType, List<Point> points, DrawObjectStyle drawObjectStyle) {
			super();
			
			this.drawType = drawType;
			this.setPoints(points);
			this.setDrawObjectStyle(drawObjectStyle);
		}
		

		/**
		 * copy constructor
		 * 
		 * @param AbstractDrawObject abstractDrawObject
		 * @throws NullPointerException
		 */
		public AbstractDrawObject(AbstractDrawObject abstractDrawObject) {
			this(abstractDrawObject.drawType, abstractDrawObject.points, abstractDrawObject.drawObjectStyle);
		}
		
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
		 * get the points
		 * 
		 * @return List<Point>
		 */
		public List<Point> getPoints() {
			return points;
		}

		/**
		 * set the points
		 * 
		 * If <code>points</code> null this function throws an NullPointerException
		 * 
		 * @param points
		 * @return void
		 * @throws NullPointerException
		 */
		public void setPoints(List<Point> points) {
			List<Point> newPoints = new ArrayList<Point>();
			for(int index=0; index<points.size(); index++) {
				newPoints.add(new Point(points.get(index)));
			}
			
			this.points = newPoints;
		}
		
		/**
		 * get the draw object style
		 * 
		 * @return DrawObjectStyle
		 */
		public DrawObjectStyle getDrawObjectStyle() {
			return drawObjectStyle;
		}
		
		/**
		 * set the draw object style
		 * 
		 * if <code>drawObjectStyle</code> is null this function throws an IllegalArgumentException
		 * 
		 * @param DrawObjectStyle drawObjectStyle
		 * @return void
		 */
		public void setDrawObjectStyle(DrawObjectStyle drawObjectStyle) {
			this.drawObjectStyle = new DrawObjectStyle(drawObjectStyle);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((drawObjectStyle == null) ? 0 : drawObjectStyle.hashCode());
			result = prime * result + ((points == null) ? 0 : points.hashCode());
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
			AbstractDrawObject other = (AbstractDrawObject) obj;
			if (drawObjectStyle == null) {
				if (other.drawObjectStyle != null)
					return false;
			} else if (!drawObjectStyle.equals(other.drawObjectStyle))
				return false;
			if (points == null) {
				if (other.points != null)
					return false;
			} else if (!points.equals(other.points))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "AbstractDrawObject [points=" + points + ", drawObjectStyle=" + drawObjectStyle + "]";
		}
}
