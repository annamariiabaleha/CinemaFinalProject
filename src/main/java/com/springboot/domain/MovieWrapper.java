package com.springboot.domain;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.entity.Movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MovieWrapper {

	public Movie movie;
	public MultipartFile file;
	
}
