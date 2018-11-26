package com.vidhilekh.stubber.rest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestRequestController {
	
	@RequestMapping(path = "/stub/**", consumes = MediaType.ALL_VALUE , produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> allRequest(HttpServletRequest httpRequest, @RequestBody(required = false) String reqBody) throws IOException{
		System.out.println("resource url:" + httpRequest.getRequestURI()+" Method:"+httpRequest.getMethod());
		ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode jsonNode = objectMapper.readValue(reqBody, JsonNode.class);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("content-type", MediaType.APPLICATION_JSON_VALUE).body(jsonNode.toString());
	}
	
	@RequestMapping(path = "/stub/**", method=RequestMethod.GET, consumes = MediaType.ALL_VALUE , produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> getRequest(HttpServletRequest httpRequest) {
		System.out.println("resource url:" + httpRequest.getRequestURI()+" Method:"+httpRequest.getMethod());
		return ResponseEntity.status(HttpStatus.OK).header("content-type", MediaType.APPLICATION_JSON_VALUE).body("{\"one\": \"AAA\"}");
	}

}
