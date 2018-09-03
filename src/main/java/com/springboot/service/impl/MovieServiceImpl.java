package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Movie;
import com.springboot.repository.MovieRepository;
import com.springboot.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public Movie findMovieById(int id) {
		return movieRepository.findOne(id);
	}

	@Override
	public Movie findMovieByName(String name) {
		return movieRepository.findMovieByName(name);
	}

	@Override
	public List<Movie> findAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public void deleteMovieById(int movieId) {
		movieRepository.delete(movieId);		
	}

}
