package com.vidhilekh.stubber.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.model.registration.LoggedUser;

@Controller()
public class StubRegistrationController {
	
	private LoggedUser loggedUser;
	private ApiDetails apiDetails;

	//sample
    @PostMapping("/stubber/register")
    public String greeting(@ModelAttribute LoggedUser loggedUser) {
        return "greeting";
    }
    
    //login page
    @GetMapping("/stubber/login")
    public String login(Model model) {
    	loggedUser = new LoggedUser();
    	model.addAttribute("loggedUser", loggedUser);
    	return "userLogin";
    }
    
    //Frame page
    @PostMapping("/stubber/mainFrame")
    public String registerApi(@ModelAttribute LoggedUser loggedUser) {
    	this.loggedUser=loggedUser;
        return "mainFrame";
    }
    
    //Dashboard
    @GetMapping("/stubber/dashboard")
    public String dashboard(Model model) {
    	model.addAttribute("loggedUser", loggedUser);
    	return "dashboard";
    }
    
    //API register
    @GetMapping("/stubber/api/register")
    public String apiRegister(Model model) {
    	apiDetails=new ApiDetails();
    	apiDetails.setCreatedBy(loggedUser.getUsername());
    	apiDetails.setModifiedBy(loggedUser.getUsername());
    	model.addAttribute("apiDetails", apiDetails);
    	model.addAttribute("loggedUser", loggedUser);
    	return "api/register";
    }
    
    //default page
    @GetMapping("/stubber/**")
    public String loginRedirect(Model model) {
    	return login(model);
    }

}
