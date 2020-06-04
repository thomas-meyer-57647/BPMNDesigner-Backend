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
import com.metho.bpmndesigner.model.PaletteEntity;
import com.metho.bpmndesigner.model.TextDecorationEntity;
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.repositories.TextDecorationRepository;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a text deocration
 * 
 * TextDecorationEntity createGradient(UserEntity creator, TextDecorationEntity textdecoration)	
 * 																				create a <code>TextDecorationEntity</code> in the database
 * Optional<TextDecorationEntity> findById(long textdecorationID)				get a <code>TextDecorationEntity</code> with the ID <code>textdecorationID</code>
 * Optional<TextDecorationEntity> findByName(UserEntity creator, String name) 	get a <code>TextDecorationEntity</code> by his name <code>name</code>
 * List<TextDecorationEntity> findAll(UserEntity creator) 						get all text decorations from the user <code>creator</code> 
 * final TextDecorationEntity updateTextDecoration(UserEntity updaterUser, Long textdecorationID, TextDecorationEntity textdecorationDetails)
 * 																				update a <code>TextDecorationEntity</code> with the id <code>textdecorationID</code> from the User
 * void deleteTextDecoration(long textdecorationID) 					 		delete a <code>TextDecorationEntity</code> uwith the ID <code>textdecorationID</code>
 */
@Service
public class TextDecorationService {
	
    @Autowired
    private TextDecorationRepository textdecorationRepository;
    
    @Autowired
    private UserRepository UserRepository;

    /**
     * the sequenceGeneratorService for the auto-increment
     */
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    /**
     * create a text decortion in the database
     * 
     * @param UserEntity creator	 				the creator
     * @param TextDecorationEntity palette			the text decoration to save
     * @return TextDecorationEntity					the created text decoration
     * @throw ResourceNotFoundException				if <code>creator</code> not exists
     */
    public TextDecorationEntity createTextDecoration(UserEntity creator, TextDecorationEntity textdeocration) throws ResourceNotFoundException {
    	if ( creator != null ) {
    		UserRepository.findById(creator.getId())
    			.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
    	}
    	
    	textdeocration.setId(sequenceGeneratorService.generateSequence(PaletteEntity.SEQUENCE_NAME));
    	textdeocration.setCreatedBy(creator);
    	textdeocration.setCreatedAt(LocalDateTime.now());
    	
        return textdecorationRepository.save(textdeocration);
    }
    
    /**
     * get a <code>TextDecorationEntity</code> with the ID <code>textdeocrationID</code> 
     * from the database
     * 
     * @param Long textdeocrationID
     * @return Optional<TextDecorationEntity>
     */
    public Optional<TextDecorationEntity> findById(long textdeocrationID) {
    	return textdecorationRepository.findById(textdeocrationID);
    }
    
    /**
     * get a <code>TextDecorationEntity</code> by his name <code>name</code>
     * 
     * @param UserEntity creator			the creator of the text decoration
     * @param String name					the name of the gradient
     * @return Optional<TextDecorationEntity>
     */
    public Optional<TextDecorationEntity> findByName(UserEntity creator, String name) {
    	return textdecorationRepository.findByCreatedByAndName(creator, name);
    }
    
    /**
     * get all text decorations from the user 
     * 
     * @return List<User>
     */
    public List<TextDecorationEntity> findAll(UserEntity creator) {
        return textdecorationRepository.findByCreatedBy(creator);
    }
    
    /**
     * update a <code>TextDecorationEntity</code> with the id <code>textdecorationID</code> from the User 
     * <code>updaterUser</code> in the database
     * 
     * If a <code>TextDecorationEntity</code> with the id <code>textdecorationID</code> not found this function
     * will be throw a ResourceNotFoundException
     * 
     * @param UserEntity updaterUser							the updated
     * @param long textdecorationID								the id of the gradient
     * @param TextDecorationEntity textdecorationDetails		the information to update
     * @return TextDecorationEntity								the updated text decoration
     * @throws ResourceNotFoundException						if a <code>TextDecorationEntity</code> with the <code>textdecorationID</code> not found
     */
    public final TextDecorationEntity updateTextDecoration(UserEntity updaterUser, Long textdecorationID, TextDecorationEntity textdecorationDetails) throws ResourceNotFoundException {
    	TextDecorationEntity textdecoration = textdecorationRepository.findById(textdecorationID)
        		.orElseThrow(() -> new ResourceNotFoundException("Text decoration not found for this id :: " + textdecorationID));
        
    	textdecoration.setUpdatedBy(updaterUser);
    	textdecoration.setUpdatedAt(LocalDateTime.now());
    	textdecoration.setName(textdecorationDetails.getName());
    	textdecoration.setFont(textdecorationDetails.getFont());
    	textdecoration.setMatrix(textdecorationDetails.getMatrix());
    	textdecoration.setAlign(textdecorationDetails.getAlign());
    	textdecoration.setBaseline(textdecorationDetails.getBaseline());
    	textdecoration.setDirection(textdecorationDetails.getDirection());
        
        return textdecorationRepository.save(textdecoration);
    }
   
    /**
     * delete a <code>TextDecorationEntity</code> uwith the ID <code>textdecorationID</code> from the database
     * 
     * @param long							  the id to delete
     * @return void
     * @throws ResourceNotFoundException	- if a <code>TextDecorationEntity</code> with the given <code>textdecorationID</code> not exists
     */
    public void deleteTextDecoration(long textdecorationID) throws ResourceNotFoundException {
    	TextDecorationEntity textdecoration = textdecorationRepository.findById(textdecorationID)
        		.orElseThrow(() -> new ResourceNotFoundException("Text decoration not found for this id :: " + textdecorationID));
        
    	textdecorationRepository.delete(textdecoration);
    }
    
}
