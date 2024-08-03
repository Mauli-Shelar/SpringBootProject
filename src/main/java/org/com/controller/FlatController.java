package org.com.controller;

import org.com.model.Flat;
import org.com.service.FlatService;
import org.com.streamapi.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
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
}
