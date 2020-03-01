package com.vidhilekh.stubber.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vidhilekh.stubber.registration.utils.ResourceReader;

@Configuration
public class SpringConfig {
	
	/**
	 * This bean will return css as string
	 */
	@Bean
	public String cssResourceString() {
	    return ResourceReader.readFileToString("/static/css/styles.css");
	}

}