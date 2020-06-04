package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.LineDashEntity;
import com.metho.bpmndesigner.model.PaletteEntity;
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.repositories.LineDashRepository;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a line dash
 * 
 * LineDashEntity createLineDash(UserEntity creator, LineDashEntity linedash)	create a <code>LineDashEntity</code> in the database
 * Optional<LineDashEntity> findById(long linedashID)							get a <code>LineDashEntity</code> with the ID <code>id</code>
 * Optional<LineDashEntity> findByName(LineDashEntity creator, String name) 	get a <code>LineDashEntity</code> by his name <code>name</code>
 * List<LineDashEntity> findAll(UserEntity creator)								get all line dashes from the user <code>creator</code>
 * final LineDashEntity updateLineDash(UserEntity updaterUser, Long linedashID, LineDashEntity lineDashDetails)
 * 																				update a <code>LineDashEntity</code> with the id <code>linedashID</code> from the User
 * void deleteLineDash(long gradientID) 								 		delete a <code>LineDashEntity</code> uwith the ID <code>id</code>
 * 
 */
@Service
public class LineDashService {
	@Autowired
	private LineDashRepository lineDashRepository;
	    
	@Autowired
	private UserRepository UserRepository;
	    
	/**
	 * the sequenceGeneratorService for the auto-increment
	 */
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	    
	/**
	 * create a linedash in the database
	 * 
	 * @param UserEntity creator	 				the creator
	 * @param LineDashEntity linedash				the linedash to save
	 * @return LineDashEntity						the created linedash
	 * @throw ResourceNotFoundException				if <code>creator</code> not exists
     */
	public LineDashEntity createLineDash(UserEntity creator, LineDashEntity linedash) throws ResourceNotFoundException {
		if ( creator != null ) {
			UserRepository.findById(creator.getId())
	    		.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
	    }
	    	
	    linedash.setId(sequenceGeneratorService.generateSequence(PaletteEntity.SEQUENCE_NAME));
	    linedash.setCreatedBy(creator);
	    linedash.setCreatedAt(LocalDateTime.now());
	    	
	    return lineDashRepository.save(linedash);
	}
	    
	/**
	 * get a <code>LineDashEntity</code> with the ID <code>id</code>
	 * 
	 * @param Long linedashID
	 * @return Optional<User>
	 */
	public Optional<LineDashEntity> findById(long linedashID) {
		return lineDashRepository.findById(linedashID);
	}
	    
    /**
	 * get a <code>LineDashEntity</code> by his name <code>name</code>
	 * 
	 * @param UserEntity creator			the creator of the line dash
	 * @param String name					the name of the line dash
	 * @return Optional<LineDashEntity>
	 */
	public Optional<LineDashEntity> findByName(UserEntity creator, String name) {
		return lineDashRepository.findByCreatedByAndName(creator, name);
	}
	    
	/**
	 * get all line dashes from the user <code>creator</code>
	 * 
	 * @return List<User>
	 */
	public List<LineDashEntity> findAll(UserEntity creator) {
		return lineDashRepository.findByCreatedBy(creator);
	}
	    
	/**
	 * update a <code>LineDashEntity</code> with the id <code>linedashID</code> from the User 
	 * <code>linedashUser</code>
	 * 
	 * If a <code>LineDashEntity</code> with the id <code>linedashID</code> not found this function
	 * will be throw a ResourceNotFoundException
	 * 
	 * @param UserEntity updaterUser				the updated
	 * @param long linedashID						the id of the line dash
	 * @param LineDashEntity linedashDetails		the information to update
	 * @return LineDashEntity						the updated line dash
	 * @throws ResourceNotFoundException			if no LineDash found with the <code>linedashID</code>
	 */
	public final LineDashEntity updateLineDash(UserEntity updaterUser, Long linedashID, LineDashEntity linedashDetails) throws ResourceNotFoundException {
		LineDashEntity linedash = lineDashRepository.findById(linedashID)
				.orElseThrow(() -> new ResourceNotFoundException("Line dash not found for this id :: " + linedashID));
	        
	    linedash.setUpdatedBy(updaterUser);
	    linedash.setUpdatedAt(LocalDateTime.now());
	    linedash.setName(linedashDetails.getName());
	    linedash.setSegments(linedashDetails.getSegments());
	        
	    return lineDashRepository.save(linedash);
    }
	   
    /**
	 * delete a <code>LineDashEntity</code> with the ID <code>linedashID</code>
	 * 
	 * @param long							  the id to delete
	 * @return void
	 * @throws ResourceNotFoundException	- if a <code>LineDashEntity</code> with the given <code>linedashID</code> not exists
     */
    public void deleteLineDash(long linedashID) throws ResourceNotFoundException {
    	LineDashEntity linedash = lineDashRepository.findById(linedashID)
    			.orElseThrow(() -> new ResourceNotFoundException("Line dash not found for this id :: " + linedashID));
	        
	    lineDashRepository.delete(linedash);
    }

}
