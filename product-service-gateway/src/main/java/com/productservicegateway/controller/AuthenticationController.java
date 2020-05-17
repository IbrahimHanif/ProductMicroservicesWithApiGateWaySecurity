package com.productservicegateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservicegateway.model.AuthDetails;
import com.productservicegateway.model.UserDetail;
import com.productservicegateway.security.MyUserDetailsService;
import com.productservicegateway.util.JwtUtils;

import brave.Response;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtutil;

	@PostMapping("/gettoken")
	public ResponseEntity<AuthDetails> getToken(@RequestBody UserDetail userDetail) {
		try { 
			authManager.authenticate(
				new UsernamePasswordAuthenticationToken(userDetail.getUsername(), userDetail.getPassword()));
		} catch(BadCredentialsException ex)
		{
			throw new BadCredentialsException("Invalid Username/passwoed");
		}
		final UserDetails userdetails = userDetailsService.loadUserByUsername(userDetail.getUsername());
		final String jwtToken = jwtutil.generateToken(userdetails);
		return ResponseEntity.ok(new AuthDetails(jwtToken));
		
	}
}
