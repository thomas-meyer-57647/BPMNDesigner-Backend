package com.metho.bpmndesigner.config;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * this is the configaurtion class
 */
@Configuration
@PropertySource(value = { "classpath:bpmndesigner.properties" })
public class AppConfig {
    
}
