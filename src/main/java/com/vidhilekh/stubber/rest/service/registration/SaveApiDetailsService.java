package com.vidhilekh.stubber.rest.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidhilekh.stubber.rest.mapping.registration.ApiDetailsEntityToApiDetails;
import com.vidhilekh.stubber.rest.mapping.registration.SaveApiDetailsToApiDetailsEntity;
import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.rest.repositories.registration.ApiDetailsRepository;

@Service
public class SaveApiDetailsService {
	
	private final SaveApiDetailsToApiDetailsEntity saveApiDetailsToApiDetailsEntity;
	private final ApiDetailsEntityToApiDetails apiDetailsEntityToApiDetails;
	private final ApiDetailsRepository apiDetailsRepository;
	
	@Autowired
	public SaveApiDetailsService(SaveApiDetailsToApiDetailsEntity saveApiDetailsToApiDetailsEntity,
			ApiDetailsEntityToApiDetails apiDetailsEntityToApiDetails,
			ApiDetailsRepository apiDetailsRepository) {
		this.saveApiDetailsToApiDetailsEntity = saveApiDetailsToApiDetailsEntity;
		this.apiDetailsEntityToApiDetails = apiDetailsEntityToApiDetails;
		this.apiDetailsRepository = apiDetailsRepository;
	}

	public ApiDetails saveApiDetails(ApiDetails apiDetails) {
		ApiDetailsEntity apiDetailsEntity = saveApiDetailsToApiDetailsEntity.convert(apiDetails);
		ApiDetailsEntity resp = apiDetailsRepository.save(apiDetailsEntity);
		apiDetails = apiDetailsEntityToApiDetails.convert(resp, apiDetails.getCurrentUser());
		return apiDetails;
	}
	
}
