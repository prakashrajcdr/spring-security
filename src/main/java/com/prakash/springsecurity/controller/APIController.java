package com.prakash.springsecurity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.springsecurity.Util.JwtUtil;
import com.prakash.springsecurity.entity.AuthenticateRequest;

@RestController("/")
public class APIController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping("/")
	public ResponseEntity<Map<String, Object>> home(){

		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("Status", "success");
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword())
					);
			
		} catch (Exception e) {
//			throw new Exception("Invalid username / password");
			return "Invalid username / password";
		}
		return jwtUtil.generateToken(authenticateRequest.getUsername());
	}
}
