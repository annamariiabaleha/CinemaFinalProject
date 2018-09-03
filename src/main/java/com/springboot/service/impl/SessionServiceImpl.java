package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Session;
import com.springboot.repository.SessionRepository;
import com.springboot.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public void saveSession(Session session) {
		sessionRepository.save(session);
		
	}

	@Override
	public Session findSessionById(int id) {
		return sessionRepository.findOne(id);
	}

	@Override
	public List<Session> findAllSessionsByMovieId(int movieId) {
		return sessionRepository.findAllSessionsByMovieId(movieId);
	}

	@Override
	public void deleteSessionById(int sessionId) {
		sessionRepository.delete(sessionId);
	}

	@Override
	public List<Session> findAllSessionsByMovieIdFromNow(int movieId) {
		return sessionRepository.findAllSessionsByMovieIdFromNow(movieId);
	}

	

}
