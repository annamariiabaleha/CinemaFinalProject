package com.springboot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.springboot.entity.Hall;

@Component
public class HallNameValidator implements ConstraintValidator<HallNameConstraint, Hall>{

	@Override
	public void initialize(HallNameConstraint arg0) {
				
	}

	@Override
	public boolean isValid(Hall hall, ConstraintValidatorContext ctx) {
		if (hall.getName() != null || hall.getName().substring(0, 3) == "Hall" 
				|| hall.getName().substring(5).matches("\\d+")) {
			return true;
		}
		return false;
	}
	

}
