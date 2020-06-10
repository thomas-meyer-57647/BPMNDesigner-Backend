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
import com.metho.bpmndesigner.model.GradientEntity;
import com.metho.bpmndesigner.model.PaletteEntity;
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.repositories.GradientRepository;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a gradient
 * 
 * GradientEntity createGradient(UserEntity creator, GradientEntity gradient)	create a <code>GradientEntity</code> in the database
 * Optional<GradientEntity> findById(long gradientID)							get a <code>GradientEntity</code> with the ID <code>id</code>
 * Optional<GradientEntity> findByName(UserEntity creator, String name) 		get a <code>GradientEntity</code> by his name <code>name</code>
 * List<GradientEntity> findAll(UserEntity creator)								get all gradients from the user <code>creator</code>
 * final GradientEntity updateGradient(UserEntity updaterUser, Long gradientID, GradientEntity gradientDetails)
 * 																				update a <code>GradientEntity</code> with the id <code>gradientID</code> from the User
 * void deleteGradient(long gradientID) throws ResourceNotFoundException 		delete a <code>GradientEntity</code> uwith the ID <code>id</code>
 * 
 */
@Service
public class GradientService {
	
    @Autowired
    private GradientRepository gradientRepository;
    
    @Autowired
    private UserRepository UserRepository;
    
    /**
     * the sequenceGeneratorService for the auto-increment
     */
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    /**
     * create a gradient
     * 
     * @param UserEntity creator	 				the creator
     * @param GradientEntity palette				the gradient to save
     * @return GradientEntity						the created gradient
     * @throw ResourceNotFoundException				if <code>creator</code> not exists
     */
    public GradientEntity createGradient(UserEntity creator, GradientEntity gradient) throws ResourceNotFoundException {
    	if ( creator != null ) {
    		UserRepository.findById(creator.getId())
    			.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
    	}
    	
    	gradient.setId(sequenceGeneratorService.generateSequence(GradientEntity.SEQUENCE_NAME));
    	gradient.setCreatedBy(creator);
    	gradient.setCreatedAt(LocalDateTime.now());
    	
        return gradientRepository.save(gradient);
    }
    
    /**
     * get a <code>GradientEntity</code> with the ID <code>id</code>
     * 
     * @param Long gradientID
     * @return Optional<User>
     */
    public Optional<GradientEntity> findById(long gradientID) {
    	return gradientRepository.findById(gradientID);
    }
    
    /**
     * get a <code>GradientEntity</code> by his name <code>name</code>
     * 
     * @param UserEntity creator			the creator of the gradient
     * @param String name					the name of the gradient
     * @return Optional<GradientEntity>
     */
    public Optional<GradientEntity> findByName(UserEntity creator, String name) {
    	return gradientRepository.findByCreatedByAndName(creator, name);
    }
    
    /**
     * get all gradients from the user <code>creator</code>
     * 
     * @return List<User>
     */
    public List<GradientEntity> findAll(UserEntity creator) {
        return gradientRepository.findByCreatedBy(creator);
    }
    
    /**
     * update a <code>GradientEntity</code> with the id <code>gradientID</code> from the User 
     * <code>updaterUser</code>
     * 
     * If a <code>GradientEntity</code> with the id <code>gradientID</code> not found this function
     * will be throw a ResourceNotFoundException
     * 
     * @param UserEntity updaterUser				the updated
     * @param long gradientID						the id of the gradient
     * @param GradientEntity gradientDetails		the information to update
     * @return GradientEntity						the updated gradient
     * @throws ResourceNotFoundException			if no User found with the <code>userID</code>
     */
    public final GradientEntity updateGradient(UserEntity updaterUser, Long gradientID, GradientEntity gradientDetails) throws ResourceNotFoundException {
        GradientEntity gradient = gradientRepository.findById(gradientID)
        		.orElseThrow(() -> new ResourceNotFoundException("Gradient not found for this id :: " + gradientID));
        
        gradient.setUpdatedBy(updaterUser);
        gradient.setUpdatedAt(LocalDateTime.now());
        gradient.setGradientType(gradientDetails.getGradientType());
        gradient.setName(gradientDetails.getName());
        gradient.setIdname(gradientDetails.getIdname());
        gradient.setX1(gradientDetails.getX1());
        gradient.setY1(gradientDetails.getY1());
        gradient.setR1(gradientDetails.getR1());
        gradient.setX2(gradientDetails.getX2());
        gradient.setY2(gradientDetails.getY2());
        gradient.setR2(gradientDetails.getR2());
        gradient.setColorStops(gradientDetails.getColorStops());
        
        return gradientRepository.save(gradient);
    }
   
    /**
     * delete a <code>GradientEntity</code> uwith the ID <code>gradientID</code>
     * 
     * @param long							  the id to delete
     * @return void
     * @throws ResourceNotFoundException	- if a <code>GradientEntity</code> with the given <code>gradientID</code> not exists
     */
    public void deleteGradient(long gradientID) throws ResourceNotFoundException {
    	GradientEntity gradient = gradientRepository.findById(gradientID)
        		.orElseThrow(() -> new ResourceNotFoundException("Gradient not found for this id :: " + gradientID));
        
        gradientRepository.delete(gradient);
    }

}
