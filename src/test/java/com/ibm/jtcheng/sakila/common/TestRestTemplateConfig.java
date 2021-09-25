package com.ibm.jtcheng.sakila.common;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestRestTemplateConfig {

	@Value("${server.port}")
	private int port;

	@Value("${server.servlet.context-path}")
	private String path;

	@Bean
	public TestRestTemplate testRestTemplate() {
		var baseUrlBuilder = new StringBuilder("http://localhost:");
		baseUrlBuilder.append(port);
		baseUrlBuilder.append(Optional.ofNullable(path).orElse(""));
		var restTemplate = new RestTemplateBuilder().rootUri(baseUrlBuilder.toString());
		return new TestRestTemplate(restTemplate);
	}

}
