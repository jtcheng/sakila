package com.ibm.jtcheng.sakila.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AbstractRestApiTest {

	@Autowired
	protected TestRestTemplate restTemplate;

	@Test
	void testRestTemplateTest() {
		Assertions.assertNotNull(restTemplate);
	}

}
