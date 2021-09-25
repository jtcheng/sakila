package com.ibm.jtcheng.sakila.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.jtcheng.sakila.model.Actor;
import com.ibm.jtcheng.sakila.service.ActorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Actors", description = "Actor apis")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/actors")
@Validated
public class ActorController {

	private final ActorService actorService;

	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<List<Actor>> getActors() {
		var actors = actorService.findAll();
		return ResponseEntity.ok(actors);
	}

	@GetMapping("/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<Optional<Actor>> getActorById(@PathVariable("id") @Min(1) @Max(200) Long id) {
		return ResponseEntity.ok(actorService.findById(id));
	}

}
