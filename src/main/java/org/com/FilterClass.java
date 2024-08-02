package org.com;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.config.JwtUtil;
import org.com.exceptionHandler.exception.InvalidToken;
import org.com.model.LoginUserDetail;
import org.com.service.LoginUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import antlr.Token;


@Configuration
public class FilterClass extends OncePerRequestFilter{
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	LoginUserDetailService loginUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authString=request.getHeader("Authorization");
		String token=null;
		String userName=null;
		System.out.println("Token ......."+authString);
		if(null!=authString && authString.startsWith("Bearer"))
		{
		token=authString.substring(7);
		userName=jwtUtil.extractUsername(token);
		LoginUserDetail userDetail=(LoginUserDetail) loginUserDetailService.loadUserByUsername(userName);
		if(null!=userName && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetail,null,userDetail.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		}
		else
		{
			throw new InvalidToken("Please add valid token....");
		}
		filterChain.doFilter(request, response);
		
	}

}
