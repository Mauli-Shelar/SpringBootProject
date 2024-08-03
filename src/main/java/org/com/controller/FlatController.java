package org.com.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.com.model.Flat;
import org.com.model.Person;
import org.com.service.FlatService;
import org.com.streamapi.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.jsonwebtoken.Header;

@RestController
@RequestMapping("/v1/flat")
public class FlatController {

	
	@Autowired
	FlatService flatService;
	
	@PreAuthorize("hasRole('ROLE_NORMAL')")
	@PostMapping("/addflat")
	public String addFlatDetail(@RequestBody Flat flat) throws JsonProcessingException
	{
		flatService.addDetail(flat);
		return "Done";
	}
	
	@PreAuthorize("hasRole('ROLE_NORMAL')")
	@GetMapping("/{flatID}")
	public ResponseEntity<List<Person>> personFromFamily(@PathVariable Integer flatID)
	{
	org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
	headers.add("All OK", "true");
	return new ResponseEntity<List<Person>>(flatService.allPerson(flatID),headers,HttpStatus.OK);
	
	}
}
