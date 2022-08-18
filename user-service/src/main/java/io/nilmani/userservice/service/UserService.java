package io.nilmani.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.nilmani.userservice.entity.User;
import io.nilmani.userservice.model.Department;
import io.nilmani.userservice.model.ResponseTemplate;
import io.nilmani.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		log.info("Inside save user of UserService");
		return userRepo.save(user);
	}
	
	public ResponseTemplate getUserWithDepartment(Integer userId) {
		ResponseTemplate templet = new ResponseTemplate();
		User user = userRepo.findByUserId(userId);
		
		
//		Department department =
//				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/", user.getDepartmentId(),Department.class);
		
		 Department department =
	                restTemplate.getForObject("http://department-service/department/" + user.getDepartmentId()
	                        ,Department.class);
		 
//		 Department department =
//				 restTemplate.getForObject("http://localhost:9001/department/", user.getDepartmentId(),Department.class);

		
		templet.setUser(user);
		templet.setDepartment(department);
		
		return templet;
	}

}
