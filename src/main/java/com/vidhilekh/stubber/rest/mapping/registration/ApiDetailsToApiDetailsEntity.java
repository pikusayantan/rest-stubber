package com.vidhilekh.stubber.rest.mapping.registration;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.vidhilekh.stubber.rest.model.registration.ApiDetails;
import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;

@Component
public class ApiDetailsToApiDetailsEntity {
	
	public ApiDetailsEntity convertToSave(ApiDetails apiDetails) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ApiDetailsEntity apiDetailsEntity = new ApiDetailsEntity();
		apiDetailsEntity.setApiName(apiDetails.getApiName());
		apiDetailsEntity.setCreatedBy(apiDetails.getCurrentUser());
		apiDetailsEntity.setCreatedOn(ts);
		apiDetailsEntity.setLastModifiedBy(apiDetails.getCurrentUser());
		apiDetailsEntity.setLastModifiedOn(ts);
		return apiDetailsEntity;
	}
	
	public ApiDetailsEntity convertToUpdate(ApiDetails apiDetails) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ApiDetailsEntity apiDetailsEntity = new ApiDetailsEntity();
		apiDetailsEntity.setApiId(apiDetails.getApiId());
		apiDetailsEntity.setApiName(apiDetails.getApiName());
		apiDetailsEntity.setLastModifiedBy(apiDetails.getCurrentUser());
		apiDetailsEntity.setLastModifiedOn(ts);
		return apiDetailsEntity;
	}

}
