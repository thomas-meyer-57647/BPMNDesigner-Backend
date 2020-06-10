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
import com.metho.bpmndesigner.model.DocumentEntity;
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.repositories.DocumentRepository;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a document
 * 
 * DocumentEntity createDocument(UserEntity creator, Document gradient)			create a <code>DocumentEntity</code> in the database
 * Optional<DocumentEntity> findById(long documentID)							get a <code>DocumentEntity</code> with the ID <code>documentID</code>
 * Optional<DocumentEntity> findByName(UserEntity creator, String name) 		get a <code>DocumentEntity</code> by his name <code>name</code>
 * List<DocumentEntity> findAll(UserEntity creator)								get all documents from the user <code>creator</code>
 * final DocumentEntity updateDocument(UserEntity updaterUser, Long documentID, DocumentEntity documentDetails)
 * 																				update a <code>DocumentEntity</code> with the id <code>documentID</code> from the User
 * void deleteDocument(long documentID) 										delete a <code>DocumentEntity</code> with the ID <code>documentID</code>
 * 
 */
@Service
public class DocumentService {
	
    @Autowired
    private DocumentRepository documentRepository;
    
    @Autowired
    private UserRepository UserRepository;
    
    /**
     * the sequenceGeneratorService for the auto-increment
     */
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    /**
     * create a document in the database
     * 
     * @param UserEntity creator	 				the creator
     * @param DocumentEntity palette				the document to save
     * @return DocumentEntity						the created document
     * @throw ResourceNotFoundException				if <code>creator</code> not exists
     */
    public DocumentEntity createDocument(UserEntity creator, DocumentEntity document) throws ResourceNotFoundException {
    	if ( creator != null ) {
    		UserRepository.findById(creator.getId())
    			.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
    	}
    	
    	document.setId(sequenceGeneratorService.generateSequence(DocumentEntity.SEQUENCE_NAME));
    	document.setCreatedBy(creator);
    	document.setCreatedAt(LocalDateTime.now());
    	
        return documentRepository.save(document);
    }
    
    /**
     * get a <code>DocumentEntity</code> with the ID <code>documentID</code>
     * 
     * @param Long documentID
     * @return Optional<User>
     */
    public Optional<DocumentEntity> findById(long documentID) {
    	return documentRepository.findById(documentID);
    }
    
    /**
     * get a <code>DocumentEntity</code> by his name <code>name</code>
     * 
     * @param UserEntity creator			the creator of the document
     * @param String name					the name of the document
     * @return Optional<DocumentEntity>
     */
    public Optional<DocumentEntity> findByName(UserEntity creator, String name) {
    	return documentRepository.findByCreatedByAndName(creator, name);
    }
    
    /**
     * get all documents from the user <code>creator</code>
     * 
     * @return List<User>
     */
    public List<DocumentEntity> findAll(UserEntity creator) {
        return documentRepository.findByCreatedBy(creator);
    }
    
    /**
     * update a <code>DocumentEntity</code> with the id <code>documentID</code> from the User 
     * <code>updaterUser</code>
     * 
     * If a <code>DocumentEntity</code> with the id <code>documentID</code> not found this function
     * will be throw a ResourceNotFoundException
     * 
     * @param UserEntity updaterUser				the updated
     * @param long documentID						the id of the document
     * @param DocumentEntity documentDetails		the information to update
     * @return DocumentEntity						the updated document
     * @throws ResourceNotFoundException			if no User found with the <code>userID</code>
     */
    public final DocumentEntity updateDocument(UserEntity updaterUser, Long documentID, DocumentEntity documentDetails) throws ResourceNotFoundException {
        DocumentEntity document = documentRepository.findById(documentID)
        		.orElseThrow(() -> new ResourceNotFoundException("Document not found for this id :: " + documentID));

        documentDetails.setId(documentID);
        documentDetails.setCreatedAt(document.getCreatedAt());
        documentDetails.setCreatedBy(document.getCreatedBy());
        documentDetails.setUpdatedAt(LocalDateTime.now());
        documentDetails.setUpdatedBy(updaterUser);
        
        return documentRepository.save(documentDetails);
    }
   
    /**
     * delete a <code>DocumentEntity</code> uwith the ID <code>documentID</code>
     * 
     * If a <code>DocumentEntity</code> with the <code>documentID</code> not exists, this function
     * will be thrown a ResourceNotFoundException
     * 
     * @param long							  the id to delete
     * @return void
     * @throws ResourceNotFoundException	- if a <code>DocumentEntity</code> with the given <code>documentID</code> not exists
     */
    public void deleteDocument(long documentID) throws ResourceNotFoundException {
    	DocumentEntity document = documentRepository.findById(documentID)
        		.orElseThrow(() -> new ResourceNotFoundException("Document not found for this id :: " + documentID));
        
        documentRepository.delete(document);
    }

}
