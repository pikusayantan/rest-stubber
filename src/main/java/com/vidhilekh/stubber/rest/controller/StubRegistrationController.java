package com.vidhilekh.stubber.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vidhilekh.stubber.rest.model.registration.LoggedUser;

@Controller()
public class StubRegistrationController {
	
	private LoggedUser loggedUser;

    @PostMapping("/stubber/register")
    public String greeting(@ModelAttribute LoggedUser loggedUser) {
    	System.out.println("object "+loggedUser.getUsername());
    	System.out.println("object "+this.loggedUser.getUsername());
        return "greeting";
    }
    
    @GetMapping("/stubber/login")
    public String login(Model model) {
    	loggedUser = new LoggedUser();
    	model.addAttribute("loggedUser", loggedUser);
    	return "userLogin";
    }
    
    @GetMapping("/stubber/**")
    public String loginRedirect(Model model) {
    	return login(model);
    }

}
