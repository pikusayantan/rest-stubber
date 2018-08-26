package com.vidhilekh.stubber.rest.controller.registration.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.service.registration.SaveApiDetailsService;

@Controller
public class StubApiController {
	
	private ApiDetails apiDetails;
	private SaveApiDetailsService saveApiDetailsService;
	
	@Autowired
	public StubApiController(SaveApiDetailsService saveApiDetailsService) {
		this.saveApiDetailsService = saveApiDetailsService;
	}
	

	//API register
    @GetMapping("/stubber/api/register")
    public String apiRegister(Model model, @RequestParam String username) {
    	apiDetails=new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	apiDetails.setCreatedBy(username);
    	apiDetails.setModifiedBy(username);
    	model.addAttribute("apiDetails", apiDetails);
    	return "api/register";
    }
    
    //Save api details to db 
    @PostMapping("/stubber/api/register/save")
    public String saveApi(@ModelAttribute ApiDetails apiDetails) {
//    	this.apiDetails = saveApiDetailsService.saveApiDetails();
        return "api/showApiDetails";
    }
	
}
