package com.vks.xebia.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class XebiaAssignmentApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(XebiaAssignmentApplication.class, args);
	}

}
