package org.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.com.constant.GlobalConstant;
import org.com.exceptionHandler.exception.UserAlreadyPresent;
import org.com.model.LoginUser;
import org.com.repo.LoginUserRepo;
import org.com.requestModel.UserRequestModel;
import org.com.responseModel.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {

	Logger logger = LogManager.getLogger(LoginUserService.class);

	@Autowired
	LoginUserRepo loginUserRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public ResponseModel saveLoginUser(UserRequestModel userRequestModel) throws UserAlreadyPresent {
		LoginUser user = loginUserRepo.getByUsername(userRequestModel.getUsername().toLowerCase());
		if (null==user) {
			LoginUser loginUser = new LoginUser();
			loginUser.setUsername(userRequestModel.getUsername().toLowerCase());
			loginUser.setPassword(bCryptPasswordEncoder.encode(userRequestModel.getPassword()));
			loginUser.setMobile(userRequestModel.getMobile());
			loginUser.setEmail(userRequestModel.getEmail());
			loginUser.setAccountNonExpired(true);
			loginUser.setAccountNonLocked(true);
			loginUser.setCredentialsNonExpired(true);
			loginUser.setEnabled(true);
			loginUser.setRole(GlobalConstant.DEFAULT_ROLE);
			loginUserRepo.save(loginUser);
			ResponseModel responseModel = new ResponseModel(loginUser.getUsername(), loginUser.getMobile(),
					loginUser.getEmail(), loginUser.getRole(), loginUser.isAccountNonExpired(),
					loginUser.isAccountNonLocked(), loginUser.isCredentialsNonExpired(), loginUser.isEnabled());
			logger.debug("[saveLoginUser] User Created...... " + responseModel);
			return responseModel;
		} else {
			logger.error("[saveLoginUser] User Already Present in Database with User name "
					+ userRequestModel.getUsername());
			throw new UserAlreadyPresent(
					"User Already Present in Database with User name " + userRequestModel.getUsername());
		}

	}
	
	
	public List<ResponseModel> allUsers()
	{
		List<ResponseModel> alluser=new ArrayList<>();
		List<LoginUser> all=loginUserRepo.findAll();
		for (LoginUser loginUser : all) {
			ResponseModel model=new ResponseModel();
			model.setUsername(loginUser.getUsername());
			model.setMobile(loginUser.getMobile());
			model.setEmail(loginUser.getEmail());
			alluser.add(model);
		}
		return alluser;
	}
}