package com.eshop.authservice.resource;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.authservice.domain.User;
import com.eshop.authservice.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		return principal;
	}

	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user) {
		userService.create(user);
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public ResponseEntity<User> profile() {

		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String email = user + "@gmail.com";

		User profile = User.builder().username(user).email(email).build();

		return ResponseEntity.ok(profile);
	}
}
