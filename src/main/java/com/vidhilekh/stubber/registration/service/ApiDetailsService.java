package com.vidhilekh.stubber.registration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vidhilekh.stubber.registration.mapping.ApiDetailsEntityToApiDetails;
import com.vidhilekh.stubber.registration.mapping.ApiDetailsToApiDetailsEntity;
import com.vidhilekh.stubber.registration.model.ApiDetails;
import com.vidhilekh.stubber.registration.model.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.registration.repositories.ApiDetailsRepository;

@Service
public class ApiDetailsService {
	
	private final ApiDetailsToApiDetailsEntity apiDetailsToApiDetailsEntity;
	private final ApiDetailsEntityToApiDetails apiDetailsEntityToApiDetails;
	private final ApiDetailsRepository apiDetailsRepository;
	
	@Autowired
	public ApiDetailsService(ApiDetailsToApiDetailsEntity apiDetailsToApiDetailsEntity,
			ApiDetailsEntityToApiDetails apiDetailsEntityToApiDetails,
			ApiDetailsRepository apiDetailsRepository) {
		this.apiDetailsToApiDetailsEntity = apiDetailsToApiDetailsEntity;
		this.apiDetailsEntityToApiDetails = apiDetailsEntityToApiDetails;
		this.apiDetailsRepository = apiDetailsRepository;
	}

	//Save API details
	public ApiDetails saveApiDetails(ApiDetails apiDetails) {
		ApiDetailsEntity apiDetailsEntity = apiDetailsToApiDetailsEntity.convertToSave(apiDetails);
		ApiDetailsEntity resp = apiDetailsRepository.save(apiDetailsEntity);
		return apiDetailsEntityToApiDetails.convertForSave(resp, apiDetails.getCurrentUser());
	}
	
	//Update api details
	public ApiDetails updateApiDetails(ApiDetails apiDetails) {
		ApiDetailsEntity apiDetailsEntity = apiDetailsToApiDetailsEntity.convertToUpdate(apiDetails);
		ApiDetailsEntity resp = apiDetailsRepository.save(apiDetailsEntity);
		return apiDetailsEntityToApiDetails.convertForUpdate(resp, apiDetails);
	}

	//Search API details by Api Name
	public List<ApiDetailsEntity> searchApiDetailsList(ApiDetails apiDetails) {
		return apiDetailsRepository.findByApiNameContainingIgnoreCase(apiDetails.getApiName());
	}
	
	//Return list of api name in json string by searching apiName pattern
	public String searchApiNameByNamePattern(String apiName) {
		List<ApiDetailsEntity> resp = apiDetailsRepository.findByApiNameContainingIgnoreCase(apiName);
		List<String> apiNameList = new ArrayList<>();
		for(ApiDetailsEntity entity : resp) {
			apiNameList.add(entity.getApiName());
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonSt = null;
		try {
			jsonSt = mapper.writeValueAsString(apiNameList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonSt;
	}

	//Search Api details by Api ID
	public ApiDetails searchApiDetailsById(ApiDetails apiDetails) {
		Optional<ApiDetailsEntity> resp = apiDetailsRepository.findById(apiDetails.getApiId());
		ApiDetailsEntity respEntity = null;
		if(resp.isPresent()) {
			respEntity = resp.get();
		}else {
			//throw some exception
		}
		return apiDetailsEntityToApiDetails.convertForSave(respEntity, apiDetails.getCurrentUser());
	}

	//Delete Api details by Api Id
	public ApiDetails deleteApiDetailsById(ApiDetails apiDetails) {
		ApiDetailsEntity apiDetailsEntity = apiDetailsToApiDetailsEntity.convertToDeleteById(apiDetails);
		apiDetailsRepository.delete(apiDetailsEntity);
		return apiDetails;
	}

}
