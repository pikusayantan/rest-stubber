package com.vidhilekh.stubber.registration.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vidhilekh.stubber.registration.service.ApiDetailsService;

@RestController
public class StubRestController {
	
	private final ApiDetailsService apiDetailsService;
	
	@Autowired
	public StubRestController(ApiDetailsService apiDetailsService) {
		this.apiDetailsService = apiDetailsService;
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

}