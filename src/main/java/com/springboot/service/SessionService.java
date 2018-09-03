package com.springboot.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.springboot.entity.Session;

public interface SessionService {

	void saveSession (Session session);
	
	void deleteSessionById (int sessionId);
	
	Session findSessionById (int id);
	
	List<Session> findAllSessionsByMovieId (int movieId);
	
	List<Session> findAllSessionsByMovieIdFromNow (int movieId);
}
