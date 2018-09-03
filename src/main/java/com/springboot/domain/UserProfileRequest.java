package com.springboot.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserProfileRequest {

	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String city;
	private String country;
	private String phoneNumber;
	private Role role;
	private String imagePath;
	private MultipartFile file;
	
	
	private List<String> favFruits = new ArrayList<>();
	
}
