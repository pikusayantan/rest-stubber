package com.vidhilekh.stubber.rest.model.registration.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "RESOURCE_DETAILS")
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"RESOURCE_NAME", "RESOURCE_METHOD"}))
@DynamicUpdate
public class ResourceDetailsEntity implements Serializable {

	private static final long serialVersionUID = 3837373609718282371L;
	
	@Id
	@Column(name = "RESOURCE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resourceId;

	@Column(name = "RESOURCE_NAME")
	private String resourceName;
	
	@Column(name = "RESOURCE_METHOD")
	private String resourceMethod;
	
	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "CREATED_ON", updatable = false)
	private Timestamp createdOn;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	@Column(name = "LAST_MODIFIED_ON")
	private Timestamp lastModifiedOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "API_ID", referencedColumnName = "API_ID")
	ApiDetailsEntity apiDetailsEntity;

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceMethod() {
		return resourceMethod;
	}

	public void setResourceMethod(String resourceMethod) {
		this.resourceMethod = resourceMethod;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Timestamp lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public ApiDetailsEntity getApiDetailsEntity() {
		return apiDetailsEntity;
	}

	public void setApiDetailsEntity(ApiDetailsEntity apiDetailsEntity) {
		this.apiDetailsEntity = apiDetailsEntity;
	}

}
