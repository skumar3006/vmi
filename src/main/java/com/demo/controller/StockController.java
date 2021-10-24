package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.User;
import com.demo.service.UserService;

@RestController
@Validated
@RequestMapping(path="/v1/stock")
public class StockController {

	@Autowired
	UserService userService;
	
    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

        userService.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<User> getAllUser(@Range(min = 0l, message = "Please select positive integer value for 'offset'") 
                @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                @Range(min = 1l, message = "Please select positive integer and should be greater than 0 for 'limit'")
                @RequestParam(value = "limit", required = false, defaultValue = "50") Integer limit, 
                @RequestParam(value = "sort", required = false) String sort,
                @RequestParam MultiValueMap<String, String> allRequestParams) {

        return userService.getAllUser(offset, limit, sort, allRequestParams);
    }
}
