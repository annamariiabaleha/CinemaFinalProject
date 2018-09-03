package com.springboot.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.domain.ImageRequest;
import com.springboot.domain.UserProfileRequest;
import com.springboot.entity.UserEntity;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import com.springboot.service.utils.CustomFileUtils;

@Controller
@RequestMapping ("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping 
	@PreAuthorize("hasRole('USER')")
	public String showProfile(Model model, Principal principal) throws IOException {
		UserEntity user = userService.findUserByEmail(principal.getName());
		
		user.setImagePath(CustomFileUtils.getImage("profile_pictures_folder", user.getImagePath()));
		model.addAttribute("userProfile", UserMapper.entityToUserProfile(user));
		return "user/profile";
		
	}
	
	@GetMapping ("{userId}/edit-profile")
	public String editUser (Model model, @PathVariable ("userId") int userId) {
		model.addAttribute("userModel",UserMapper.entityToUserProfile(userService.findUserById(userId)) );
		return "user/edit-profile";	
	}
	
	@PostMapping ("{userId}/edit-profile")
	public String updateUser (@ModelAttribute ("userModel") UserProfileRequest user) throws IOException {
		UserEntity userEntity = UserMapper.userProfileToEntity(user);
		userEntity.setImagePath("user_" + userEntity.getId());

		CustomFileUtils.createImage("profile_pictures_folder", userEntity.getImagePath(), user.getFile());
		userService.updateUser(userEntity);
		return "redirect:/user";
		
	}
	
	
}
