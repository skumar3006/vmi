package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmail(String username);

}
