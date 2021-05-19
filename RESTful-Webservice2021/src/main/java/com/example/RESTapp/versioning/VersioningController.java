package com.example.RESTapp.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	/****BASIC WAY OF VERSIONING/ URI VERSIONING*******/
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	/**** VERSIONING USING REQUEST PARAM *******/
	@GetMapping(value = "params/person", params = "version=1")
	public PersonV1 paramPersonV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value = "params/person", params = "version=2")
	public PersonV2 paramPersonV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	/****** VERSIONING USING REQUEST HEADER/ MIME TYPE VERSIONING *****/
	@GetMapping(value = "header/person", headers =  "API-VERSION=1")
	public PersonV1 headerPersonV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value = "header/person", headers = "API-VERSION=2")
	public PersonV2 headerPersonV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	} 
	
	
	/**** VERSIONING USING CONTENT NEGOTIATION OR ACCEPT HEADER *******/
	@GetMapping(value = "produces/person", produces =  "apploication/v1.xml")
	public PersonV1 producesPersonV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value = "produces/person", produces = "apploication/v2.xml")
	public PersonV2 producesPersonV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	} 
}
