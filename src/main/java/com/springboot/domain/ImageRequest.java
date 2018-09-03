package com.springboot.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImageRequest {
	
	private MultipartFile file;
	
}
