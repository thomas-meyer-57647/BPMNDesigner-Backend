package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.time.LocalDateTime;

/**
 * this is the interface for all storeable datas
 */
public interface IStoreable {
	LocalDateTime getCreatedAt();
	void setCreatedAt(LocalDateTime created_at);

//	User getCreatedBy();
//	void setCreatedBy(User created_by);

	LocalDateTime getUpdatedAt();
	void setUpdatedAt(LocalDateTime updated_at);

//	User getUpdatedBy();
//	void setUpdatedBy(User updated_by);
}
