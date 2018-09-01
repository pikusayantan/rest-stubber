package com.vidhilekh.stubber.rest.controller.registration.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidhilekh.stubber.rest.model.registration.ApiDetails;

@Controller
public class StubResourceController {
	
	//API register
    @GetMapping("/stubber/resource/register")
    public String apiRegister(Model model, @RequestParam String username) {
    	ApiDetails apiDetails=new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	model.addAttribute("apiDetails", apiDetails);
    	return "resource/createResource";
    }

}
