package com.prakash.springsecurity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class APIController {

	@RequestMapping("/")
	public ResponseEntity<Map<String, Object>> home(){

		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("Status", "success");
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

}
