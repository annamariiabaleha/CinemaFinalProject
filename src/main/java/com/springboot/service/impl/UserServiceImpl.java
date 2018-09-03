package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.entity.UserEntity;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;
import com.springboot.service.utils.CustomFileUtils;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserEntity entity) {

		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		userRepository.save(entity);
		CustomFileUtils.createFolder("user_" + entity.getId());
		
	}

	@Override
	public UserEntity findUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public void updateUser(UserEntity entity) {
		userRepository.save(entity);
	}

}
