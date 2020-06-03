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
import org.springframework.boot.test.context.SpringBootTest;

/**
 * test function for the GradientFillStyle class
 */
@SpringBootTest
class GradientStyleTest {

	/**
	 * get getFillStyleType()
	 */
	@Test
	void testGetFillStyleType() {
		GradientStyle gradientFillStyle = new GradientStyle();
		
		assertEquals(EStyleType.GRADIENT, gradientFillStyle.getStyleType());
	}

	/**
	 * test clone
	 */
	@Test
	void testClone() {
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "a gradient";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 4;
		int y2 = 5;
		int r2 = 6;
		
		Color color1 = new Color(255);
		double offset1 = .05f;
		ColorStop colorStop1 = new ColorStop(offset1, color1);
		
		Color color2 = new Color(1);
		double offset2 = .75f;
		ColorStop colorStop2 = new ColorStop(offset2, color2);

		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		colorstops.add(colorStop1);
		colorstops.add(colorStop2);
		
		GradientStyle gradientStyle = new GradientStyle(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		GradientStyle newGradientStyle = gradientStyle.clone();

		assertTrue(gradientStyle != newGradientStyle);
		assertEquals(gradientStyle.getStyleType(), newGradientStyle.getStyleType());
		assertEquals(gradientStyle.getGradientType(), newGradientStyle.getGradientType());
		assertEquals(gradientStyle.getName(), newGradientStyle.getName());
		assertEquals(gradientStyle.getIdname(), newGradientStyle.getIdname());
		assertEquals(gradientStyle.getX1(), newGradientStyle.getX1());
		assertEquals(gradientStyle.getY1(), newGradientStyle.getY1());
		assertEquals(gradientStyle.getR1(), newGradientStyle.getR1());
		assertEquals(gradientStyle.getX2(), newGradientStyle.getX2());
		assertEquals(gradientStyle.getY2(), newGradientStyle.getY2());
		assertEquals(gradientStyle.getR2(), newGradientStyle.getR2());
		assertEquals(gradientStyle.getColorStops().size(), newGradientStyle.getColorStops().size());
		assertEquals(gradientStyle.getColorStops().get(0), newGradientStyle.getColorStops().get(0));
		assertEquals(gradientStyle.getColorStops().get(1), newGradientStyle.getColorStops().get(1));
	}
	
}
