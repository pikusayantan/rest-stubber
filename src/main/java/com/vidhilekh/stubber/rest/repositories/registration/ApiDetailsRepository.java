package com.vidhilekh.stubber.rest.repositories.registration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;

public interface ApiDetailsRepository extends JpaRepository<ApiDetailsEntity, Long> {

//    List<Customer> findByLastName(String lastName);
	
}