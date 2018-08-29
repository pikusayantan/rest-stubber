package com.vidhilekh.stubber.rest.controller.registration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;
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
    
    //Edit api details on form button click
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
    
    //Edit api details on sidepane option click
    @GetMapping("/stubber/api/edit")
    public String editApi(Model model, @RequestParam String username) {
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowSearchDiv(true);
    	ApiDetails apiDetails = new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	model.addAttribute("apiDetails", apiDetails);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return "api/showApiDetails";
    }
    
    //Update api details to db
    @PostMapping("/stubber/api/search")
    public String searchApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	List<ApiDetailsEntity> apiDetailsRespList = apiDetailsService.searchApiDetailsList(apiDetails);
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	if(apiDetailsRespList.isEmpty()) {
    		renderShowApiDetails.setShowNoResultDiv(true);
    	}else {
    		renderShowApiDetails.setShowSearchListDiv(true);
    	}
    	renderShowApiDetails.setShowSearchDiv(true);
    	model.addAttribute("apiDetailsList", apiDetailsRespList);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
    	model.addAttribute("apiDetails", apiDetails);
        return "api/showApiDetails";
    }
    
    //Edit api details from table list of apis
    @GetMapping("/stubber/api/editbyid")
    public String editApiById(Model model, @RequestParam String username, @RequestParam String apiid ) {
    	ApiDetails apiDetails = new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	apiDetails.setApiId(Long.parseLong(apiid));
    	
    	ApiDetails apiDetailsResp = apiDetailsService.searchApiDetailsById(apiDetails);
    	
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowEditApiDiv(true);
    	
    	model.addAttribute("apiDetails", apiDetailsResp);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return "api/showApiDetails";
    }
	
}
