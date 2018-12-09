package com.vidhilekh.stubber.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.vidhilekh.stubber.registration.model.LoggedUser;

@Controller
public class StubRegistrationController {

	/*
	 * Registration Page
	 * This is not implemented.
	 * This will be used for registering new user
	 * As of now no registration required
	 */
    @PostMapping("/stubber/register")
    public String greeting(@ModelAttribute LoggedUser loggedUser) {
        return "greeting";
    }
    
    /*
     * Login Page:
     * This is Login page for first Page
     * User will be asked to input their username.
     */
    @GetMapping("/stubber/login")
    public String login(Model model) {
    	LoggedUser loggedUser = new LoggedUser();
    	model.addAttribute("loggedUser", loggedUser);
    	return "userLogin";
    }
    
    /*
     * Frame page:
     * This will show whole dashboard and side navigation 
     * after login successfully
     */
    @PostMapping("/stubber/mainFrame")
    public String registerApi(@ModelAttribute LoggedUser loggedUser) {
        return "mainFrame";
    }
    
    /*
     * Dashboard Page:
     * This page not been implemented.
     * Intend of this page is to show several statistics.
     */
    @GetMapping("/stubber/dashboard")
    public String dashboard(Model model, @RequestParam String username) {
    	System.out.println("here is dashboard");
    	model.addAttribute("username", username);
    	return "dashboard";
    } 
    
    /*
     * default page for any other URLs
     * redirect to login page
     */
    @GetMapping("/stubber/**")
    public RedirectView loginRedirect(Model model) {
    	RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/stubber/login");
        return redirectView;
    }

}
