package com.vidhilekh.stubber.rest.service.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidhilekh.stubber.rest.mapping.registration.ApiDetailsEntityToApiDetails;
import com.vidhilekh.stubber.rest.mapping.registration.ApiDetailsToApiDetailsEntity;
import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.rest.repositories.registration.ApiDetailsRepository;

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

	public ApiDetails saveApiDetails(ApiDetails apiDetails) {
		ApiDetailsEntity apiDetailsEntity = apiDetailsToApiDetailsEntity.convertToSave(apiDetails);
		ApiDetailsEntity resp = apiDetailsRepository.save(apiDetailsEntity);
		return apiDetailsEntityToApiDetails.convertForSave(resp, apiDetails.getCurrentUser());
	}
	
	public ApiDetails updateApiDetails(ApiDetails apiDetails) {
		ApiDetailsEntity apiDetailsEntity = apiDetailsToApiDetailsEntity.convertToUpdate(apiDetails);
		ApiDetailsEntity resp = apiDetailsRepository.save(apiDetailsEntity);
		return apiDetailsEntityToApiDetails.convertForUpdate(resp, apiDetails);
	}

	public List<ApiDetailsEntity> searchApiDetailsList(ApiDetails apiDetails) {
		List<ApiDetailsEntity> respList = apiDetailsRepository.findByApiNameContainingIgnoreCase(apiDetails.getApiName());
		return respList;
	}

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

}
