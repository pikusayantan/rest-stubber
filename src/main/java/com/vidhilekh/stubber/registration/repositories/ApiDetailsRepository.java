package com.vidhilekh.stubber.registration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidhilekh.stubber.registration.model.entity.ApiDetailsEntity;

public interface ApiDetailsRepository extends JpaRepository<ApiDetailsEntity, Long> {

	List<ApiDetailsEntity> findByApiNameContainingIgnoreCase(String apiName);

	ApiDetailsEntity findByApiName(String apiName);	

}