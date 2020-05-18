package com.metho.bpmndesigner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class BpmnDesignerApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BpmnDesignerApplication.class, args);

//		AppConfig config = ctx.getBean(AppConfig.class);
//		System.out.println(config.getBaseDirectory());

//		System.out.println(workspaceService.getBaseDirectoryName());		
	}

}
