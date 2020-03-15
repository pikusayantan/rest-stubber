package com.vidhilekh.stubber.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidhilekh.stubber.registration.model.ResourceDetails;
import com.vidhilekh.stubber.registration.service.ResourceDetailsService;
import com.vidhilekh.stubber.registration.utils.CommonUtils;

@Controller
public class StubResourceController {
	
	private static final String RESOURCE_DETAILS = "resourceDetails";
	private static final String HTTP_METHOD_LIST = "httpMethodList";
	
	private final ResourceDetailsService resourceDetailsService;
	
	@Autowired
	public StubResourceController(ResourceDetailsService resourceDetailsService) {
		this.resourceDetailsService = resourceDetailsService;
	}
	
	//When Resource > Create is clicked on left pane from main frame
    @GetMapping("/stubber/resource/create")
    public String apiRegister(Model model, @RequestParam String username) {
    	ResourceDetails resourceDetails = new ResourceDetails();
    	resourceDetails.setCurrentUser(username);
    	model.addAttribute(RESOURCE_DETAILS, resourceDetails);
    	model.addAttribute(HTTP_METHOD_LIST, CommonUtils.httpMethods);
    	return "resource/createResource";
    }
    
    //Save resource details to db when Submit button is clicked in Create Resource page
    @PostMapping("/stubber/resource/create/save")
    public String saveApi(Model model, @ModelAttribute ResourceDetails resourceDetails) {
    	resourceDetailsService.saveResourceDetails(resourceDetails);
    	ResourceDetails resourceDetailsModel = new ResourceDetails();
    	resourceDetailsModel.setCurrentUser(resourceDetails.getCurrentUser());
    	resourceDetailsModel.setApiName(resourceDetails.getApiName());
    	model.addAttribute(RESOURCE_DETAILS, resourceDetailsModel);
    	model.addAttribute(HTTP_METHOD_LIST, CommonUtils.httpMethods);
    	return "resource/createResource";
    }

}
