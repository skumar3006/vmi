package com.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.demo.entities.Role;
import com.demo.entities.User;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	public List<User> getAllUser(Integer offset, Integer limit, String sort,
			MultiValueMap<String, String> allRequestParams) {
		return (List<User>) userRepository.findAll();
	}

	public void createUser(@Valid User user) {
		
		if(StringUtils.isEmpty(user.getRoleName())) {
			Role role = Role.getByName(user.getRoleName());
			user.setRole(role);
		}
		userRepository.save(user);
		
	}

}
