package com.vidhilekh.stubber.registration.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "API_DETAILS")
@DynamicUpdate
public class ApiDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1043033575097072403L;

	@Id
	@Column(name = "API_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long apiId;

	@Column(name = "API_NAME")
	private String apiName;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "CREATED_ON", updatable = false)
	private Timestamp createdOn;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	@Column(name = "LAST_MODIFIED_ON")
	private Timestamp lastModifiedOn;
	
	@OneToMany(mappedBy="apiDetailsEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<ResourceDetailsEntity> resourceDetailsEntityList = new ArrayList<>();

	public Long getApiId() {
		return apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
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

	public List<ResourceDetailsEntity> getResourceDetailsEntityList() {
		return resourceDetailsEntityList;
	}

	public void setResourceDetailsEntityList(List<ResourceDetailsEntity> resourceDetailsEntityList) {
		this.resourceDetailsEntityList = resourceDetailsEntityList;
	}

}
