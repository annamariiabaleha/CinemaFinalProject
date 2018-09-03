package com.springboot.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.springboot.domain.RegisterRequest;
import com.springboot.domain.UserProfileRequest;
import com.springboot.entity.UserEntity;
import com.springboot.entity.enumeration.Role;

public interface UserMapper {

	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity registerToEntity (RegisterRequest request) {
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setDateOfBirth(request.getDateOfBirth());
		entity.setRole(Role.ROLE_USER);
		
		return entity;
	}
	
	public static UserProfileRequest entityToUserProfile (UserEntity entity) {
		UserProfileRequest request = new UserProfileRequest();
		request.setId(entity.getId());
		request.setCity(entity.getCity());
		request.setCountry(entity.getCountry());
		request.setDateOfBirth(entity.getDateOfBirth());
		request.setEmail(entity.getEmail());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setPhoneNumber(entity.getPhoneNumber());
		request.setRole(entity.getRole());
		request.setImagePath(entity.getImagePath());
		
		return request;
		
	}
	
	public static UserEntity userProfileToEntity (UserProfileRequest userProfile) {
		UserEntity request = new UserEntity();
		request.setId(userProfile.getId());
		request.setCity(userProfile.getCity());
		request.setCountry(userProfile.getCountry());
		request.setDateOfBirth(userProfile.getDateOfBirth());
		request.setEmail(userProfile.getEmail());
		request.setFirstName(userProfile.getFirstName());
		request.setLastName(userProfile.getLastName());
		request.setPhoneNumber(userProfile.getPhoneNumber());
		request.setRole(userProfile.getRole());
		request.setImagePath(userProfile.getImagePath());
		
		return request;
	}
		
	
}
