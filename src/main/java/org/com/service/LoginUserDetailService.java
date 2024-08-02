package org.com.service;

import org.com.model.LoginUser;
import org.com.model.LoginUserDetail;
import org.com.repo.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailService implements UserDetailsService {
	
	@Autowired
	LoginUserRepo loginUserRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser loginUser=loginUserRepo.getByUsername(username);
		return new LoginUserDetail(loginUser);
	}

	
	
}
