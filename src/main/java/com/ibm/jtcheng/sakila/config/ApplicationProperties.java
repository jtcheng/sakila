package com.ibm.jtcheng.sakila.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("application")
@Setter
@Getter
public class ApplicationProperties {

	private String name;
	private String version;
	private String description;
}
