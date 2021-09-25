package com.ibm.jtcheng.sakila.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibm.jtcheng.sakila.model.Actor;
import com.ibm.jtcheng.sakila.repository.ActorRepository;
import com.ibm.jtcheng.sakila.service.ActorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

	private final ActorRepository actorRepository;

	@Override
	public List<Actor> findAll() {
		return actorRepository.findAll();
	}

	@Override
	public Optional<Actor> findById(Long id) {
		return actorRepository.findById(id);
	}

}
