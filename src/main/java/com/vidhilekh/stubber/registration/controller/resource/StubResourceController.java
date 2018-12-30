package com.vidhilekh.stubber.registration.controller.resource;

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
	
	private final ResourceDetailsService resourceDetailsService;
	
	@Autowired
	public StubResourceController(ResourceDetailsService resourceDetailsService) {
		this.resourceDetailsService = resourceDetailsService;
	}
	
	//Resource creation for the API
    @GetMapping("/stubber/resource/create")
    public String apiRegister(Model model, @RequestParam String username) {
    	ResourceDetails resourceDetails = new ResourceDetails();
    	resourceDetails.setCurrentUser(username);
    	model.addAttribute("resourceDetails", resourceDetails);
    	model.addAttribute("httpMethodList", CommonUtils.httpMethods);
    	return "resource/createResource";
    }
    
    //Save resource details to db 
    @PostMapping("/stubber/resource/create/save")
    public String saveApi(Model model, @ModelAttribute ResourceDetails resourceDetails) {
    	System.out.println("+++++============+++++++"+resourceDetails.getApiName());
    	System.out.println("+++++============+++++++"+resourceDetails.getResourceMethod());
    	resourceDetailsService.saveResourceDetails(resourceDetails);
    	return "resource/createResource";
    }

}