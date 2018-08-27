package com.vidhilekh.stubber.rest.controller.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidhilekh.stubber.rest.model.registration.LoggedUser;

@Controller
public class StubRegistrationController {

	//sample
    @PostMapping("/stubber/register")
    public String greeting(@ModelAttribute LoggedUser loggedUser) {
        return "greeting";
    }
    
    //login page
    @GetMapping("/stubber/login")
    public String login(Model model) {
    	LoggedUser loggedUser = new LoggedUser();
    	model.addAttribute("loggedUser", loggedUser);
    	return "userLogin";
    }
    
    //Frame page
    @PostMapping("/stubber/mainFrame")
    public String registerApi(@ModelAttribute LoggedUser loggedUser) {
        return "mainFrame";
    }
    
    //Dashboard
    @GetMapping("/stubber/dashboard")
    public String dashboard(Model model, @RequestParam String username) {
    	model.addAttribute("username", username);
    	return "dashboard";
    }
    
    //default page
    @GetMapping("/stubber/**")
    public String loginRedirect(Model model) {
    	return login(model);
    }

}
