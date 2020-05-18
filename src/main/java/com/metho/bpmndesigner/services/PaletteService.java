package com.metho.bpmndesigner.services;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metho.bpmndesigner.entities.Color;

@Service
public class PaletteService {
	
	@Autowired
	WorkspaceService workspaceService;
	
	private static String PALETTE_EXTENSION = "pal";
	
	/**
	 * get the palette directory name
	 * 
	 * @return String
	 */
	public String getPaletteDirectoryName(String dirname) {
		return workspaceService.getPaletteDirectoryName(dirname);
	}
	
	/**
	 * get the palette directory path
	 * 
	 * @return Path
	 */
	public Path getPaletteDirectoryPath(String dirname) {
		return workspaceService.getPalettetDirectoryPath(dirname);
	}
	
	/**
	 * get all palettes
	 * 
	 * if no palettes exists this function return empty List<String>
	 * 
	 * @return List<String>
	 */
	public Collection<File> getAllPalettes(String name) {
		  String directoryName = this.getPaletteDirectoryName(name);
		  String extension = "*" + PaletteService.PALETTE_EXTENSION;
		  
		  File directory = new File(directoryName);
		  Collection<File> files = FileUtils.listFiles(directory, new WildcardFileFilter(extension), null);
		  
		  return files;
	}
	
	/**
	 * get the filename of a palette "name"
	 * 
	 * @param String name					the name of the work directory
	 * @return String
	 */
	public static String getFilename(String name) {
		return name + PaletteService.PALETTE_EXTENSION;
	}
	
	/**
	 * get all the filename of a palette "name"
	 * 
	 * @param String name					the name of the work directory
	 * @return List<String>
	 */
	public List<String> getAllPaletteNames(String name) {
		List<String> names = new ArrayList<String>();
		Collection<File> files = this.getAllPalettes(name);
		
		files.forEach(item->names.add( FilenameUtils.getBaseName(item.getName()) ));
		
		return names;
	}
	
	/**
	 * save a palette
	 * 
	 * @param String dirname					the name of the work directory
	 * @param String name   					the name of the palette
	 * @oaran List<Color> colors				the colors of the palette
	 * 
	 * @return boolean
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InvalidFileFormatException 
	 */	
	public void save(String dirname, String name, List<Color> colors) throws InvalidFileFormatException, FileNotFoundException, IOException {
		String filename = this.getPaletteDirectoryName(dirname) + "";
		Ini ini = new Ini(new FileReader(filename));
	}
	
	/**
	 * check if a palette exists
	 * 
	 * @param String					the name of the palette
	 * @return boolean
	 */	
}
