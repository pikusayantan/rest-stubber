package com.vidhilekh.stubber.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidhilekh.stubber.registration.mapping.ResourceDetailsToResourceDetailsEntity;
import com.vidhilekh.stubber.registration.model.ResourceDetails;
import com.vidhilekh.stubber.registration.model.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.registration.model.entity.ResourceDetailsEntity;
import com.vidhilekh.stubber.registration.repositories.ApiDetailsRepository;
import com.vidhilekh.stubber.registration.repositories.ResourceDetailsRepository;

@Service
public class ResourceDetailsService {
	
	private final ApiDetailsRepository apiDetailsRepository;
	private final ResourceDetailsRepository resourceDetailsRepository;
	private final ResourceDetailsToResourceDetailsEntity resourceDetailsToResourceDetailsEntity;
	
	@Autowired
	public ResourceDetailsService(ApiDetailsRepository apiDetailsRepository, 
			ResourceDetailsRepository resourceDetailsRepository,
			ResourceDetailsToResourceDetailsEntity resourceDetailsToResourceDetailsEntity) {
		this.apiDetailsRepository = apiDetailsRepository;
		this.resourceDetailsRepository = resourceDetailsRepository;
		this.resourceDetailsToResourceDetailsEntity = resourceDetailsToResourceDetailsEntity;
	}

	public ResourceDetailsEntity saveResourceDetails(ResourceDetails resourceDetails) {
		ApiDetailsEntity apiDetailsEntity = apiDetailsRepository.findByApiName(resourceDetails.getApiName());
		ResourceDetailsEntity resourceDetailsEntity = resourceDetailsToResourceDetailsEntity.convertToSave(apiDetailsEntity,resourceDetails);
		return resourceDetailsRepository.save(resourceDetailsEntity);	
	}

}
