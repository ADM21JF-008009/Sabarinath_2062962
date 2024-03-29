package com.cognizant.ormlearn.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.respository.AttemptRepository;

@Service
public class AttemptService {
	
	@Autowired
	private AttemptRepository attemptRepository;
	
	@Transactional
	public Attempt getAttemptById() {
		return attemptRepository.getAttempt(1, 2);
	}
	
	
}