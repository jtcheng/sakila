package com.ibm.jtcheng.sakila.service;

import java.util.List;
import java.util.Optional;

import com.ibm.jtcheng.sakila.model.Actor;

public interface ActorService {

	List<Actor> findAll();

	Optional<Actor> findById(Long id);
}
