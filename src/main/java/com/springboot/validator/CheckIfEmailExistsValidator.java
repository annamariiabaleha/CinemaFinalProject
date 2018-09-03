package com.springboot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.service.UserService;

@Component
public class CheckIfEmailExistsValidator implements ConstraintValidator<CheckIfEmailExists, String> {

	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(CheckIfEmailExists arg0) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		return userService.findUserByEmail(email) == null ? true : false;
	}

}
