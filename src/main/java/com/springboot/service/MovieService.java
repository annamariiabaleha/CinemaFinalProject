package com.springboot.service;

import java.util.List;

import com.springboot.entity.Movie;

public interface MovieService {

	void saveMovie(Movie movie);
	
	void deleteMovieById (int movieId);
	
	Movie findMovieById (int id);
	
	Movie findMovieByName (String name);
	
	List<Movie> findAllMovies ();
}
