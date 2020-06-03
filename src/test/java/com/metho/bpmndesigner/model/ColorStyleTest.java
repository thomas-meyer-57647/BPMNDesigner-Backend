package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * test ColorFillStyle
 */
@SpringBootTest
class ColorStyleTest {

	/**
	 * test getType
	 */
	@Test
	void testGetType() {
		ColorStyle color = new ColorStyle(255);
		
		assertEquals(EStyleType.COLOR, color.getStyleType());
	}
	
	/**
	 * test clone
	 */
	@Test
	void testColor() {
		int colorvalue = 255;
		Float transparency = 0.5f;
		String name = "a ColorStyle";
		
		ColorStyle colorStyle = new ColorStyle();
		
		colorStyle.setColorvalue(colorvalue);
		colorStyle.setTransparency(transparency);
		colorStyle.setName(name);
		
		ColorStyle newColorStyle = colorStyle.clone();
		
		assertTrue(colorStyle != newColorStyle);
		assertEquals(colorvalue, newColorStyle.getColorValue());
		assertEquals(transparency, newColorStyle.getTransparency());
		assertEquals(name, newColorStyle.getName());
		assertEquals(colorStyle.getStyleType(), newColorStyle.getStyleType());
	}
	

}
