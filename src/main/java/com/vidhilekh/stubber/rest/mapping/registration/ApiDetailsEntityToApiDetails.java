package com.vidhilekh.stubber.rest.mapping.registration;

import org.springframework.stereotype.Component;

import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;

@Component
public class ApiDetailsEntityToApiDetails {
	
	public ApiDetails convert(ApiDetailsEntity apiDetailsEntity, String currentUser) {
		ApiDetails apiDetails = new ApiDetails();
		apiDetails.setCurrentUser(currentUser);
		apiDetails.setApiName(apiDetailsEntity.getApiName());
		apiDetails.setCreatedBy(apiDetailsEntity.getCreatedBy());
		apiDetails.setCreatedOn(apiDetailsEntity.getCreatedOn().toLocalDateTime().toString());
		apiDetails.setLastModifiedBy(apiDetailsEntity.getLastModifiedBy());
		apiDetails.setLastModifiedOn(apiDetailsEntity.getLastModifiedOn().toLocalDateTime().toString());
		return apiDetails;
	}

}
