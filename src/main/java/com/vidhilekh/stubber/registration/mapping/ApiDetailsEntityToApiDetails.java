package com.vidhilekh.stubber.registration.mapping;

import org.springframework.stereotype.Component;

import com.vidhilekh.stubber.registration.model.ApiDetails;
import com.vidhilekh.stubber.registration.model.entity.ApiDetailsEntity;

@Component
public class ApiDetailsEntityToApiDetails {
	
	public ApiDetails convertForSave(ApiDetailsEntity apiDetailsEntity, String currentUser) {
		ApiDetails apiDetails = new ApiDetails();
		apiDetails.setCurrentUser(currentUser);
		apiDetails.setApiId(apiDetailsEntity.getApiId());
		apiDetails.setApiName(apiDetailsEntity.getApiName());
		apiDetails.setCreatedBy(apiDetailsEntity.getCreatedBy());
		apiDetails.setCreatedOn(apiDetailsEntity.getCreatedOn().toLocalDateTime().toString());
		apiDetails.setLastModifiedBy(apiDetailsEntity.getLastModifiedBy());
		apiDetails.setLastModifiedOn(apiDetailsEntity.getLastModifiedOn().toLocalDateTime().toString());
		return apiDetails;
	}

	public ApiDetails convertForUpdate(ApiDetailsEntity apiDetailsEntity, ApiDetails apiDetailsResp) {
		ApiDetails apiDetails = new ApiDetails();
		apiDetails.setCurrentUser(apiDetailsResp.getCurrentUser());
		apiDetails.setApiId(apiDetailsEntity.getApiId());
		apiDetails.setApiName(apiDetailsEntity.getApiName());
		apiDetails.setCreatedBy(apiDetailsResp.getCreatedBy());
		apiDetails.setCreatedOn(apiDetailsResp.getCreatedOn());
		apiDetails.setLastModifiedBy(apiDetailsEntity.getLastModifiedBy());
		apiDetails.setLastModifiedOn(apiDetailsEntity.getLastModifiedOn().toLocalDateTime().toString());
		return apiDetails;
	}
}
