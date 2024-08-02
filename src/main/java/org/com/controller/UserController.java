package org.com.controller;

import java.util.List;

import org.com.service.LoginUserService;
import org.com.service.exception.AddAllAttributeForUserCreation;
import org.com.service.exception.UserAlreadyPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import requestModel.UserRequestModel;
import responseModel.ResponseModel;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	LoginUserService loginUserService;

	@PostMapping("/signup")
	public ResponseEntity<ResponseModel> createUser(@RequestBody UserRequestModel userRequestModel)
			throws UserAlreadyPresent {

		if (!userRequestModel.getUsername().isBlank() && !userRequestModel.getPassword().isBlank()
				&& !userRequestModel.getMobile().isBlank() && !userRequestModel.getEmail().isBlank()) {
			return new ResponseEntity<ResponseModel>(loginUserService.saveLoginUser(userRequestModel),
					HttpStatus.CREATED);
		} else {
			throw new AddAllAttributeForUserCreation("Data not added inside request......");
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/allregisterusers")
	public ResponseEntity<List<ResponseModel>> allRegisterUsers()
	{
		return new ResponseEntity<List<ResponseModel>>(loginUserService.allUsers(),HttpStatus.OK);
	}
}
