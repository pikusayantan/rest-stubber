package com.vidhilekh.stubber.registration.mapping;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.vidhilekh.stubber.registration.model.ResourceDetails;
import com.vidhilekh.stubber.registration.model.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.registration.model.entity.ResourceDetailsEntity;

@Component
public class ResourceDetailsToResourceDetailsEntity {
	
	public ResourceDetailsEntity convertToSave(ApiDetailsEntity apiDetailsEntity, ResourceDetails resourceDetails) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ResourceDetailsEntity resourceDetailsEntity = new ResourceDetailsEntity();
		resourceDetailsEntity.setApiDetailsEntity(apiDetailsEntity);
		resourceDetailsEntity.setResourceName(resourceDetails.getResourceName());
		resourceDetailsEntity.setResourceMethod(resourceDetails.getResourceMethod());
		resourceDetailsEntity.setCreatedBy(resourceDetails.getCurrentUser());
		resourceDetailsEntity.setCreatedOn(ts);
		resourceDetailsEntity.setLastModifiedBy(resourceDetails.getCurrentUser());
		resourceDetailsEntity.setLastModifiedOn(ts);
		return resourceDetailsEntity;
	}

}
