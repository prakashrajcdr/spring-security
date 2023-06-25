package com.prakash.springsecurity;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.prakash.springsecurity.entity.User;
import com.prakash.springsecurity.serviceImpl.ServiceImpl;

@SpringBootApplication
public class SpringSecurityApplication {

	@Autowired
	private ServiceImpl serviceImpl;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		System.out.println("Hellow World!");
	}

	@PostConstruct
	public void addUsers() {
		List<User> users = Arrays.asList(new User(1, "user1", bCryptPasswordEncoder.encode("pass1"), true), new User(2, "user2", bCryptPasswordEncoder.encode("pass2"), true));
		serviceImpl.addUsers(users);
	}
}
