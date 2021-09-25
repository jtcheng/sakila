package com.ibm.jtcheng.sakila.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import com.ibm.jtcheng.sakila.common.AbstractRestApiTest;
import com.ibm.jtcheng.sakila.model.Actor;

class ActorControllerTest extends AbstractRestApiTest {

	@Test
	void getActorsTest() {
		var response = restTemplate.exchange("/actors", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Actor>>() {
				});
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(200, response.getBody().size());
	}
}
