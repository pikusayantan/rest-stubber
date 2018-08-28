package com.vidhilekh.stubber.rest.controller.registration.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.model.registration.render.RenderShowApiDetails;
import com.vidhilekh.stubber.rest.service.registration.ApiDetailsService;

@Controller
public class StubApiController {
	
	private final ApiDetailsService apiDetailsService;
	
	@Autowired
	public StubApiController(ApiDetailsService apiDetailsService) {
		this.apiDetailsService = apiDetailsService;
	}
	

	//API register
    @GetMapping("/stubber/api/register")
    public String apiRegister(Model model, @RequestParam String username) {
    	ApiDetails apiDetails=new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	model.addAttribute("apiDetails", apiDetails);
    	return "api/register";
    }
    
    //Save api details to db 
    @PostMapping("/stubber/api/register/save")
    public String saveApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	ApiDetails apiDetailsResp = apiDetailsService.saveApiDetails(apiDetails);
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowDisplayApiDiv(true);
    	model.addAttribute("apiDetails", apiDetailsResp);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return "api/showApiDetails";
    }
    
    //Edit api details
    @PostMapping("/stubber/api/edit")
    public String editApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowEditApiDiv(true);
    	model.addAttribute("apiDetails", apiDetails);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return "api/showApiDetails";
    }
    
    //Update api details to db
    @PostMapping("/stubber/api/update")
    public String updateApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	ApiDetails apiDetailsResp = apiDetailsService.updateApiDetails(apiDetails);
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowDisplayApiDiv(true);
    	model.addAttribute("apiDetails", apiDetailsResp);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return "api/showApiDetails";
    }
	
}
