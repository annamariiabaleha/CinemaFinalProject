package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Hall;
import com.springboot.repository.HallRepository;
import com.springboot.service.HallService;

@Service
public class HallServiceImpl implements HallService {

	@Autowired
	private HallRepository hallRepository;
	
	@Override
	public void saveHall(Hall hall) {
		hallRepository.save(hall);
	}

	@Override
	public Hall findHallById(int id) {
		return hallRepository.findHallById(id);
	}

	@Override
	public void deleteHall(Hall hall) {
		hallRepository.delete(hall);		
	}

	@Override
	public List<Hall> findAllHalls() {
		return hallRepository.findAll();
	}

	@Override
	public List<Hall> findAllAvailableHalls() {
		return hallRepository.findAllAvailableHalls();
	}

	
}
