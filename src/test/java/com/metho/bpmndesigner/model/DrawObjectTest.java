package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

/**
 * test function for <code>DrawObject</code>
 */
class DrawObjectTest {

	/**
	 * test clone
	 */
	@Test
	void testClone() {
		// initialize params
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		
		ColorStyle color1 = new ColorStyle(255);
		IStyle fillStyle = color1;
		
		ColorStyle color2 = new ColorStyle(2);
		IStyle strokeStyle = color2;
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(1);
		segments.add(2);
		
		LineDash lineDash = new LineDash("a linedash", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 23;
		String text = "a text";
		
		Pair<String, String> pair1 = Pair.of("first", "second");
		Pair<String, String> pair2 = Pair.of("third", "forth");
		List<Pair<String, String>> params = new ArrayList<Pair<String, String>>();
		params.add(pair1);
		params.add(pair2);
		
		// create DrawObject
		DrawObject drawObject = new DrawObject();

		drawObject.setDrawType(drawType);
		drawObject.setName(name);
		drawObject.setPoints(points);
		drawObject.setFillStyle(fillStyle);
		drawObject.setStrokeStyle(strokeStyle);
		drawObject.setLineDash(lineDash);
		drawObject.setLineCap(lineCap);
		drawObject.setLineWidth(lineWidth);
		drawObject.setText(text);
		drawObject.setParams(params);

		// check
		DrawObject newDrawObject = drawObject.clone();
		
		assertTrue( drawObject != newDrawObject );
		assertTrue( drawObject.getPoints() != newDrawObject.getPoints() );
		assertTrue( drawObject.getFillStyle() != newDrawObject.getFillStyle() );
		assertTrue( drawObject.getStrokeStyle() != newDrawObject.getStrokeStyle() );
		assertTrue( drawObject.getLineDash() != newDrawObject.getLineDash() );
		assertTrue( drawObject.getParams() != newDrawObject.getParams() );
		
		assertEquals( drawObject, newDrawObject );
	}

}
