package com.springboot.domain;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.springboot.validator.CheckIfEmailExists;
import com.springboot.validator.CheckPasswordsMatch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMatch
public class RegisterRequest {

	@Pattern(regexp = "[a-zA-Z].+[a-zA-Z0-9+.]+@[A-Za-z]{2,5}+.[A-Za-z]{2,4}$", message = "Incorrect format")
	@CheckIfEmailExists
	@NotEmpty private String email;
	
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", message = "Password must contain at least one number, one uppercase and one lowercase letter, and at least 6 or more characters")
	@NotEmpty private String password;
	
	@NotEmpty private String passwordConfirmation;
	
	@Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)"
			+ "(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?"
			+ "2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468]"
			+ "[048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",
			message = "Invalid date format. Should use dd/mm/yyyy,dd-mm-yyyy or dd.mm.yyyy\n\n")
	@NotEmpty private String dateOfBirth;
}
