package com.vidhilekh.stubber.rest.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vidhilekh.stubber.rest.service.registration.ApiDetailsService;

@RestController
public class StubRestController {
	
	private final ApiDetailsService apiDetailsService;
	
	@Autowired
	public StubRestController(ApiDetailsService apiDetailsService) {
		this.apiDetailsService = apiDetailsService;
	}
	
    @GetMapping("/stubber/api/search")
    public String searchApi(@RequestParam String apiName) {
    	System.out.println("++++++++++"+apiName);
		return apiDetailsService.searchApiNameByNamePattern(apiName);
    }

}
