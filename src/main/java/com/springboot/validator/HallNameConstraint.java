package com.springboot.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint (validatedBy = HallNameValidator.class)
public @interface HallNameConstraint {
	
	String message() default "Invalid hall name format (should be: Hall #, ex Hall 1) or hall name already exists";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
