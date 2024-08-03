package org.com.controller;

import org.com.config.JwtUtil;
import org.com.model.LoginUserDetail;
import org.com.requestModel.JWTRequest;
import org.com.responseModel.JwtResponse;
import org.com.service.LoginUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	LoginUserDetailService loginUserDetailService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JWTRequest jwtRequest)
	{
		try
		{
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch (Exception e) {
			new BadCredentialsException("Bad credentials .......");
		}
		LoginUserDetail userDetail=(LoginUserDetail) this.loginUserDetailService.loadUserByUsername(jwtRequest.getUsername());
		
		String token=jwtUtil.generateToken(userDetail);
		
		
		return new ResponseEntity<JwtResponse>(new JwtResponse(token),HttpStatus.CREATED);
		
	}
}
