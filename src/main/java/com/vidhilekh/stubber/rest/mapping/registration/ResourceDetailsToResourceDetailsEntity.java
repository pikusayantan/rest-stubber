package com.vidhilekh.stubber.rest.mapping.registration;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.vidhilekh.stubber.rest.model.registration.ResourceDetails;
import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;
import com.vidhilekh.stubber.rest.model.registration.entity.ResourceDetailsEntity;

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
