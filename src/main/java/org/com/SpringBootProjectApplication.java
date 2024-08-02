package org.com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.com.constant.GlobalConstant;
import org.com.model.LoginUser;
import org.com.repo.LoginUserRepo;
import org.com.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {
	
	static Logger logger = LogManager.getLogger(SpringBootProjectApplication.class);

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	LoginUserRepo userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("[SpringBootProjectApplication] Admin idea creation check................... "+args[0]);
		if(null!=args[0] && args[0].equals("true"))
		{
		LoginUser loginUser = new LoginUser();
		loginUser.setUserID(1);
		loginUser.setUsername("admin");
		loginUser.setPassword(bCryptPasswordEncoder.encode("admin"));
		loginUser.setMobile("9999999999");
		loginUser.setEmail("admin@gmail.com");
		loginUser.setAccountNonExpired(true);
		loginUser.setAccountNonLocked(true);
		loginUser.setCredentialsNonExpired(true);
		loginUser.setEnabled(true);
		loginUser.setRole(GlobalConstant.ADMIN_ROLE);
		userRepo.save(loginUser);
		logger.info("[SpringBootProjectApplication] Admin user created .......");
		}
		else
		{
			logger.info("[SpringBootProjectApplication] Admin user already created .......");
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
		logger.info("[SpringBootProjectApplication] Application Main Class .......");
	}

}
