package com.ibm.jtcheng.sakila.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.jtcheng.sakila.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
