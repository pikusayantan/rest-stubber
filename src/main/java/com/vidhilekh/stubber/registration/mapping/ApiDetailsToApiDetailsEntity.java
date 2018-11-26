package com.vidhilekh.stubber.registration.mapping;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.vidhilekh.stubber.registration.model.ApiDetails;
import com.vidhilekh.stubber.registration.model.entity.ApiDetailsEntity;

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

	public ApiDetailsEntity convertToDeleteById(ApiDetails apiDetails) {
		ApiDetailsEntity apiDetailsEntity = new ApiDetailsEntity();
		apiDetailsEntity.setApiId(apiDetails.getApiId());
		return apiDetailsEntity;
	}

}
