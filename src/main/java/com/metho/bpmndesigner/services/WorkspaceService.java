package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * this is the workspace for the bpmn diagrams
 * 
 * @author tomth
 */
@Service
public class WorkspaceService {

	private static String PALETTE_DIRECTORY = "_palettes";
	private static String GRADIENT_DIRECTORY = "_gradients";
	
	@Value("${basedirectory}")
	private String baseDirectory;

	/**
	 * get the base directory name
	 * 
	 * @return String
	 */
	public String getBaseDirectoryName() {
		if ( this.baseDirectory == null || (this.baseDirectory = this.baseDirectory.trim()).length() == 0) {
			File file = new File("workspace");
			return file.getAbsolutePath();			
		}
		
		if (this.baseDirectory.charAt(this.baseDirectory.length()-1)=='\\'
		 || this.baseDirectory.charAt(this.baseDirectory.length()-1)=='/') {
			this.baseDirectory = this.baseDirectory.replace(this.baseDirectory.substring(this.baseDirectory.length()-1), "");
	    }
		
		if (this.baseDirectory.length() == 0) {
			File file = new File("workspace");
			return file.getAbsolutePath();						
		}
		
		return this.baseDirectory;
	}
	
	/**
	 * get the base directory path
	 * 
	 * @return Path
	 */
	public Path getBaseDirectoryPath() {
		return Paths.get(this.getBaseDirectoryName());
	}
	
	/**
	 * get the workspace directory name
	 * 
	 * @param dirname					the directory name of the 
	 * @return String
	 */
	public String getWorkspaceDirectoryName(String dirname) {
		if ( dirname == null || (dirname = dirname.trim()).length() == 0 ) {
		   return this.getBaseDirectoryName();
		}
		
		dirname = dirname.trim();
		
		if (dirname.charAt(dirname.length()-1)=='\\'
		 || dirname.charAt(dirname.length()-1)=='/') {
			dirname = dirname.replace(dirname.substring(dirname.length()-1), "");
	    }
		
		return (dirname.length() == 0) ? this.getBaseDirectoryName() : this.getBaseDirectoryName() + "\\" + dirname;			
    }
	
	/**
	 * get the workspace directory path
	 * 
	 * @param dirname					the directory name of the 
	 * @return Path
	 */
	public Path getWorkspaceDirectoryPath(String dirname) {
		return Paths.get(this.getBaseDirectoryName() + "\\" + dirname);
	}
	
	/**
	 * get the palette directory name
	 * 
	 * @return String
	 */
	public String getPaletteDirectoryName(String dirname) {
		return this.getWorkspaceDirectoryName(dirname) + "\\" + WorkspaceService.PALETTE_DIRECTORY;
	}
	
	/**
	 * get the palette directory path
	 * 
	 * @return String
	 */
	public Path getPalettetDirectoryPath(String dirname) {
		return Paths.get(this.getPaletteDirectoryName(dirname));
	}
	
	/**
	 * get the gradient directory name
	 * 
	 * @return String
	 */
	public String getGradientDirectoryName(String dirname) {
		return this.getWorkspaceDirectoryName(dirname) + "\\" + WorkspaceService.GRADIENT_DIRECTORY;
	}
	
	/**
	 * get the gradient directory path
	 * 
	 * @return String
	 */
	public Path getGradientDirectoryPath(String dirname) {
		return Paths.get(this.getGradientDirectoryName(dirname));
	}
	
	/**
	 * initialize workspace
	 * 
	 * check 
	 * @return Path
	 * @throws IOException
	 */
	public void initialize(String dirname) throws IOException {
		// check if baseDirectory exists and if a directory not a file
		//    If not create the base directory
		Path baseDirectory = this.getBaseDirectoryPath();

		if ( !Files.exists(baseDirectory) || !Files.isDirectory(baseDirectory) ) {
			Files.createDirectories( baseDirectory );			
		}
		
		// check if working directory exists and if a directory not a file
		//    If not create the working directory
		Path workingDirectory = this.getWorkspaceDirectoryPath(dirname);
		
		if ( !Files.exists(workingDirectory) || !Files.isDirectory(workingDirectory) ) {
			Files.createDirectories( workingDirectory );			
		}
		
		// check if the directory "_palettes" exists and if a directory not a file
		//    If not create the "_palettes" directory
		Path palettesDirectory = this.getPalettetDirectoryPath(dirname);
		
		if ( !Files.exists(palettesDirectory) || !Files.isDirectory(palettesDirectory) ) {
			Files.createDirectories( palettesDirectory );			
		}
		
		// check if the directory "_gradient" exists and if a directory not a file
		//    If not create the "_gradient" directory
		Path gradientDirectory = this.getGradientDirectoryPath(dirname);
		
		if ( !Files.exists(gradientDirectory) || !Files.isDirectory(gradientDirectory) ) {
			Files.createDirectories( gradientDirectory );			
		}
	}
	
	/**
	 * get the full path of this workspace
	 * 
	 * @return void
	 * @throws IOException 
	 */
	public void deleteWorkspace(String dirname) throws IOException {
		FileUtils.deleteDirectory(new File( this.getWorkspaceDirectoryName(dirname) ));
	}
		
}
