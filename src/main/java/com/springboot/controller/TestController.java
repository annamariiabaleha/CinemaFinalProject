package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.domain.UserProfileRequest;
import com.springboot.entity.Session;

public class TestController {
	@GetMapping ("{sessionId}/seats-selection")
	public String getSeatsSelectionPage (@PathVariable ("sessionId") int sessionId, Model model) {
	//	Session session = sessionService.findSessionById(sessionId);
		
		List<String> fruits = new ArrayList<>();
		fruits.add("banana");
		fruits.add("apple");
		fruits.add("lemon");
		fruits.add("orange");
		
		model.addAttribute("fruitsModel", fruits);
		model.addAttribute("user", new UserProfileRequest());
		return "seats-selection";
	}

	@PostMapping ("{sessionId}/seats-selection")
	public String postSelectionPage (@Valid @ModelAttribute ("fruitsModel") UserProfileRequest session, BindingResult result) {
		if (result.hasErrors()) {
			return "/admin";
		}
		
		System.out.println("Fruits you get: " + session.getFavFruits());
		return "redirect:/home";
		
	}
}
