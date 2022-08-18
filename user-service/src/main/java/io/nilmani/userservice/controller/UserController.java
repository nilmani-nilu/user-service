package io.nilmani.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nilmani.userservice.entity.User;
import io.nilmani.userservice.model.ResponseTemplate;
import io.nilmani.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User saveUser(@ModelAttribute User user) {
		log.info("inside save user of userController");
		return userService.saveUser(user);
	}
	
	/**Get user with department*/
	@GetMapping("/{id}")
	public ResponseTemplate getUserWithDepartment(@PathVariable("id") Integer userId) {
		log.info("get user with department id form  userControler database");
		return userService.getUserWithDepartment(userId);
	}

}
