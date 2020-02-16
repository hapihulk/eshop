package com.eshop.authservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eshop.authservice.domain.User;
import com.eshop.authservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	//private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private UserRepository repository;

	@Override
	public void create(User user) {

		log.info("Entered UserServiceImpl.create(User user)");
		
		Optional<User> existing = repository.findById(user.getUsername());
		existing.ifPresent(it -> {
			throw new IllegalArgumentException("user already exists: " + it.getUsername());
		});

		//String hash = encoder.encode(user.getPassword());
		///user.setPassword(hash);
		user.setPassword(user.getPassword());

		repository.save(user);

		log.info("new user has been created: {}", user.getUsername());
	}
}
