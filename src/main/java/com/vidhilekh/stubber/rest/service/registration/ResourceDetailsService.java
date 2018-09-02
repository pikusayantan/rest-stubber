package com.vidhilekh.stubber.rest.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidhilekh.stubber.rest.mapping.registration.ResourceDetailsToResourceDetailsEntity;
import com.vidhilekh.stubber.rest.model.registration.ResourceDetails;
import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.rest.model.registration.entity.ResourceDetailsEntity;
import com.vidhilekh.stubber.rest.repositories.registration.ApiDetailsRepository;
import com.vidhilekh.stubber.rest.repositories.registration.ResourceDetailsRepository;

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

	public void saveResourceDetails(ResourceDetails resourceDetails) {
		ApiDetailsEntity apiDetailsEntity = apiDetailsRepository.findByApiName(resourceDetails.getApiName());
		System.out.println("++++++++apiid"+apiDetailsEntity.getApiId());
		ResourceDetailsEntity resourceDetailsEntity = resourceDetailsToResourceDetailsEntity.convertToSave(apiDetailsEntity,resourceDetails);
		resourceDetailsRepository.save(resourceDetailsEntity);
		
	}

}
