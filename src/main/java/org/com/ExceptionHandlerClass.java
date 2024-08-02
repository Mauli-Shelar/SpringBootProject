package org.com;

import org.com.service.exception.AddAllAttributeForUserCreation;
import org.com.service.exception.InvalidToken;
import org.com.service.exception.UserAlreadyPresent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerClass {

	
	@ExceptionHandler(UserAlreadyPresent.class)
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<String> handleUserAlreadyPresent(UserAlreadyPresent userAlreadyPresent)
	{
		return new ResponseEntity<String>(userAlreadyPresent.getMessage(),HttpStatus.FOUND);
	}
	
	@ExceptionHandler(AddAllAttributeForUserCreation.class)
	@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
	public ResponseEntity<String> handleAddAllAttributeForUserCreation(AddAllAttributeForUserCreation addAllAttributeForUserCreation)
	{
		return new ResponseEntity<String>(addAllAttributeForUserCreation.getMessage(),HttpStatus.PARTIAL_CONTENT);
	}
	
	
	@ExceptionHandler(BadCredentialsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleAddAllAttributeForUserCreation(BadCredentialsException badCredentialsException)
	{
		return new ResponseEntity<String>(badCredentialsException.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidToken.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseEntity<String> handleInvalidToken(InvalidToken invalidToken)
	{
		return new ResponseEntity<String>(invalidToken.getMessage(),HttpStatus.UNAUTHORIZED);
	}
}
