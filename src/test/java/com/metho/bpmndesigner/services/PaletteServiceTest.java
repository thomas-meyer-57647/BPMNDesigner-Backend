package com.metho.bpmndesigner.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaletteServiceTest {

	@Autowired
	PaletteService paletteService;
	
	/**
	 * test getAllPalettes
	 */
	@Test
	void testGetAllPalettes() {
		Collection<File> files = paletteService.getAllPalettes("metho");
		
		assertEquals(3, files.size());
		
		assertEquals("1", FilenameUtils.getBaseName(((File)files.toArray()[0]).getName()));
		assertEquals("2", FilenameUtils.getBaseName(((File)files.toArray()[1]).getName()));
		assertEquals("3", FilenameUtils.getBaseName(((File)files.toArray()[2]).getName()));
	}
	
	/**
	 * test getAllPaletteNames
	 */
	@Test
	void testGetAllPaletteNames() {
		List<String> names = paletteService.getAllPaletteNames("metho");
		
		assertEquals(3, names.size());
		
		assertEquals("1", names.get(0) );
		assertEquals("2", names.get(1) );
		assertEquals("3", names.get(2) );
	}

}
