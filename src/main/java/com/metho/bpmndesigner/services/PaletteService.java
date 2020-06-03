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
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.repositories.PaletteRepository;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a user
 * 
 * PaletteEntity createPalette(UserEntity creator, PaletteEntity palette)       reate a palette
 * Optional<PaletteEntity> findById(long paletteID)								get a <code>PaletteEntity</code> with the ID <code>id</code>
 * Optional<PaletteEntity> findByName(UserEntity creator, String name) 			get a <code>PaletteEntity</code> by his name <code>name</code>
 * final PaletteEntity updatePalette(UserEntity updaterUser, Long paletteID, PaletteEntity paletteDetails)
 * 																				update a <code>Palette</code> with the id <code>paletteID</code> from the User
 * void deletePalette(long paletteID) throws ResourceNotFoundException 			delete a <code>PaletteEntity</code> uwith the ID <code>id</code>
 * 
 */
@Service
public class PaletteService {
	
    @Autowired
    private PaletteRepository paletteRepository;
    
    @Autowired
    private UserRepository UserRepository;
    
    /**
     * the sequenceGeneratorService for the auto-increment
     */
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    /**
     * create a palette
     * 
     * @param UserEntity creator	 				the creator
     * @param PaletteEntity palette					the palette to save
     * @return PaletteEntity						the created palette
     * @throw ResourceNotFoundException				if <code>creator</code> not exists
     */
    public PaletteEntity createPalette(UserEntity creator, PaletteEntity palette) throws ResourceNotFoundException {
    	if ( creator != null ) {
    		UserRepository.findById(creator.getId())
    			.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
    	}
    	
    	palette.setId(sequenceGeneratorService.generateSequence(PaletteEntity.SEQUENCE_NAME));
    	palette.setCreatedBy(creator);
    	palette.setCreatedAt(LocalDateTime.now());
    	
        return paletteRepository.save(palette);
    }
    
    /**
     * get a <code>PaletteEntity</code> with the ID <code>id</code>
     * 
     * @param Long paletteID
     * @return Optional<User>
     */
    public Optional<PaletteEntity> findById(long paletteID) {
    	return paletteRepository.findById(paletteID);
    }
    
    /**
     * get a <code>PaletteEntity</code> by his name <code>name</code>
     * 
     * @param UserEntity creator			the creator of the palette
     * @param String name					the name of the palette
     * @return Optional<PaletteEntity>
     */
    public Optional<PaletteEntity> findByName(UserEntity creator, String name) {
    	return paletteRepository.findByCreatedByAndName(creator, name);
    }
    
    /**
     * get all Palettes
     * 
     * @return List<User>
     */
    public List<PaletteEntity> findAll() {
        return paletteRepository.findAll();
    }
    
    /**
     * update a <code>Palette</code> with the id <code>paletteID</code> from the User 
     * <code>updaterUser</code>
     * 
     * If a <code>Palette</code> with the id <code>paletteID</code> not found this function will be
     * throw a ResourceNotFoundException
     * 
     * @param UserEntity updaterUser				the updated
     * @param long paletteID						the id of the palette
     * @param PaletteEntity paletteDetails			the information to update
     * @return PaletteEntity						the updated palette
     * @throws ResourceNotFoundException			if no User found with the <code>userID</code>
     */
    public final PaletteEntity updatePalette(UserEntity updaterUser, Long paletteID, PaletteEntity paletteDetails) throws ResourceNotFoundException {
        PaletteEntity palette = paletteRepository.findById(paletteID)
        		.orElseThrow(() -> new ResourceNotFoundException("Palette not found for this id :: " + paletteID));
        
        palette.setUpdatedBy(updaterUser);
        palette.setUpdatedAt(LocalDateTime.now());
        palette.setName(paletteDetails.getName());
        palette.setColors(paletteDetails.getColors());
        
        return paletteRepository.save(palette);
    }
   
    /**
     * delete a <code>PaletteEntity</code> uwith the ID <code>id</code>
     * 
     * @return void
     * @throws ResourceNotFoundException	- if a <code>PalrtteEntity</code> with the given <code>id</code> not exists
     */
    public void deletePalette(long paletteID) throws ResourceNotFoundException {
    	PaletteEntity palette = paletteRepository.findById(paletteID)
        		.orElseThrow(() -> new ResourceNotFoundException("Palette not found for this id :: " + paletteID));
        
        paletteRepository.delete(palette);
    }

}
