package com.ibm.jtcheng.sakila.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.ibm.jtcheng.sakila.common.AbstractRestApiTest;
import com.ibm.jtcheng.sakila.model.ApiError;

class UniformExceptionHandlerTest extends AbstractRestApiTest {

	@Test
	void NoHandlerFoundExceptionTest() {
		System.out.println(restTemplate.getRootUri());
		var response = restTemplate.getForEntity("/noexists", ApiError.class);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		Assertions.assertEquals(404, response.getBody().getStatus());
	}

}
