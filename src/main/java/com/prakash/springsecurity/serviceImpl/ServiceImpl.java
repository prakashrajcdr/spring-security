package com.prakash.springsecurity.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.springsecurity.entity.User;
import com.prakash.springsecurity.repository.UserRepository;

@Service
public class ServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	public void addUsers(List<User> users) {
		userRepository.saveAll(users);

	}

}
