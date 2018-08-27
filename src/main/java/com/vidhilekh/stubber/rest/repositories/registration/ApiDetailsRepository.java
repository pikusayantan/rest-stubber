package com.vidhilekh.stubber.rest.repositories.registration;

import org.springframework.data.repository.CrudRepository;

import com.vidhilekh.stubber.rest.model.registration.entity.ApiDetailsEntity;

public interface ApiDetailsRepository extends CrudRepository<ApiDetailsEntity, Long> {

//    List<Customer> findByLastName(String lastName);
}