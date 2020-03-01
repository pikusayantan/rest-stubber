package com.vidhilekh.stubber.registration.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vidhilekh.stubber.registration.service.ApiDetailsService;

@RestController
public class StubRestController {
	
	private final ApiDetailsService apiDetailsService;
    private final String resourceString;
	
	@Autowired
	public StubRestController(ApiDetailsService apiDetailsService,
			String resourceString) {
		this.apiDetailsService = apiDetailsService;
		this.resourceString = resourceString;
	}
	
	/*
	 * This method will return list of apis in json string by searching apiName pattern.
	 * Used by ajax call from webpages
	 */
    @GetMapping("/stubber/api/search")
    public String searchApi(@RequestParam String apiName) {
    	System.out.println("Ajax call made, and returned.." + apiName);
		return apiDetailsService.searchApiNameByNamePattern(apiName);
    }
    
    /*
	 * This method will return css content under resource folder
	 * /Resources/static/css/styles.css
	 */
	@GetMapping(path = "/css/styles.css", consumes = MediaType.ALL_VALUE , produces = MediaType.ALL_VALUE)
	public String getCss() throws IOException {
		return resourceString;
	}

}