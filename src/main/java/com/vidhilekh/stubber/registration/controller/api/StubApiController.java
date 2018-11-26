package com.vidhilekh.stubber.registration.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidhilekh.stubber.registration.model.ApiDetails;
import com.vidhilekh.stubber.registration.model.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.registration.model.render.RenderDeleteApiDetails;
import com.vidhilekh.stubber.registration.model.render.RenderShowApiDetails;
import com.vidhilekh.stubber.registration.service.ApiDetailsService;

@Controller
public class StubApiController {
	
	private final ApiDetailsService apiDetailsService;
	private static final String SHOW_API_DETAIL_PAGE = "api/showApiDetails";
	private static final String DELETE_API_DETAIL_PAGE = "api/deleteApiDetails";
	
	@Autowired
	public StubApiController(ApiDetailsService apiDetailsService) {
		this.apiDetailsService = apiDetailsService;
	}

	//API register
    @GetMapping("/stubber/api/create")
    public String apiRegister(Model model, @RequestParam String username) {
    	ApiDetails apiDetails=new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	model.addAttribute("apiDetails", apiDetails);
    	return "api/createApi";
    }
    
    //Save api details to db 
    @PostMapping("/stubber/api/create/save")
    public String saveApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	ApiDetails apiDetailsResp = apiDetailsService.saveApiDetails(apiDetails);
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowDisplayApiDiv(true);
    	model.addAttribute("apiDetails", apiDetailsResp);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return SHOW_API_DETAIL_PAGE;
    }
    
    //Edit api details on form button click
    @PostMapping("/stubber/api/edit")
    public String editApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowEditApiDiv(true);
    	model.addAttribute("apiDetails", apiDetails);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return SHOW_API_DETAIL_PAGE;
    }
    
    //Update api details to db
    @PostMapping("/stubber/api/update")
    public String updateApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	ApiDetails apiDetailsResp = apiDetailsService.updateApiDetails(apiDetails);
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowDisplayApiDiv(true);
    	model.addAttribute("apiDetails", apiDetailsResp);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return SHOW_API_DETAIL_PAGE;
    }
    
    //Edit api details on sidepane option click
    @GetMapping("/stubber/api/edit")
    public String editApi(Model model, @RequestParam String username) {
    	RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
    	renderShowApiDetails.setShowSearchDiv(true);
    	ApiDetails apiDetails = new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	apiDetails.setOperation("edit");
    	model.addAttribute("apiDetails", apiDetails);
    	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
        return SHOW_API_DETAIL_PAGE;
    }
    
    //Search api details from db
    @PostMapping("/stubber/api/search")
    public String searchApi(Model model, @ModelAttribute ApiDetails apiDetails) {
    	System.out.println("============="+apiDetails.getOperation());
    	List<ApiDetailsEntity> apiDetailsRespList = apiDetailsService.searchApiDetailsList(apiDetails);
    	
    	model.addAttribute("apiDetailsList", apiDetailsRespList);
    	model.addAttribute("apiDetails", apiDetails);
    	
    	if(apiDetails.getOperation().equalsIgnoreCase("edit")) {
    		RenderShowApiDetails renderShowApiDetails = new RenderShowApiDetails();
        	if(apiDetailsRespList.isEmpty()) {
        		renderShowApiDetails.setShowNoResultDiv(true);
        	}else {
        		renderShowApiDetails.setShowSearchListDiv(true);
        	}
        	renderShowApiDetails.setShowSearchDiv(true);
        	model.addAttribute("renderShowApiDetails", renderShowApiDetails);
    		return SHOW_API_DETAIL_PAGE;
    	} 
    	else if(apiDetails.getOperation().equalsIgnoreCase("delete")){
    		RenderDeleteApiDetails renderDeleteApiDetails = new RenderDeleteApiDetails();
    		if(apiDetailsRespList.isEmpty()) {
    			renderDeleteApiDetails.setShowNoResultDiv(true);
        	}else {
        		renderDeleteApiDetails.setShowSearchListDiv(true);
        	}
    		renderDeleteApiDetails.setShowSearchDiv(true);
        	model.addAttribute("renderDeleteApiDetails", renderDeleteApiDetails);
    		return DELETE_API_DETAIL_PAGE;
    	} 
    	return null;
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
        return SHOW_API_DETAIL_PAGE;
    }
    
    //Delete api details from sidepane option click
    @GetMapping("/stubber/api/delete")
    public String deleteApi(Model model, @RequestParam String username) {
    	RenderDeleteApiDetails renderDeleteApiDetails = new RenderDeleteApiDetails();
    	renderDeleteApiDetails.setShowSearchDiv(true);
    	ApiDetails apiDetails = new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	apiDetails.setOperation("delete");
    	model.addAttribute("apiDetails", apiDetails);
    	model.addAttribute("renderDeleteApiDetails", renderDeleteApiDetails);
        return DELETE_API_DETAIL_PAGE;
    }
    
    //Delete api details from table list of apis
    @GetMapping("/stubber/api/deletebyid")
    public String deleteApiById(Model model, @RequestParam String username, @RequestParam String apiid ) {
    	ApiDetails apiDetails = new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	apiDetails.setApiId(Long.parseLong(apiid));
    	
    	ApiDetails apiDetailsResp = apiDetailsService.deleteApiDetailsById(apiDetails);
    	
    	RenderDeleteApiDetails renderDeleteApiDetails = new RenderDeleteApiDetails();
    	renderDeleteApiDetails.setShowSearchDiv(true);
    	renderDeleteApiDetails.setShowDeleteMessageDiv(true);
    	
    	model.addAttribute("apiDetails", apiDetailsResp);
    	model.addAttribute("renderDeleteApiDetails", renderDeleteApiDetails);
        return DELETE_API_DETAIL_PAGE;
    }
    
    //Detail API search when sidepane Search option clicked need to be done
    @GetMapping("/stubber/api/detailSearch")
    public String detailSearch(Model model, @RequestParam String username) {
    	
    	ApiDetails apiDetails = new ApiDetails();
    	apiDetails.setCurrentUser(username);
    	model.addAttribute("apiDetails", apiDetails);
        return "api/detailSearch";
    }
	
}
