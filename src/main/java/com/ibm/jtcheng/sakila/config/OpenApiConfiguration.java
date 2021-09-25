package com.ibm.jtcheng.sakila.config;

import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfiguration {
	private final ApplicationProperties appProperties;

	@Bean
	public OpenAPI customOpenAPI() {
		var components = new Components();

		var info = new Info();
		info.setTitle(String.format("%s API Documentation", appProperties.getName()));
		info.setVersion(String.format("Application Version: %s%n SpringBoot Version: %s", appProperties.getVersion(),
				SpringBootVersion.getVersion()));
		info.setDescription(appProperties.getDescription());
		info.setLicense(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"));

		var externalDocs = new ExternalDocumentation();
		externalDocs.setDescription("springdoc-openapi documentation");
		externalDocs.setUrl("https://springdoc.org");

		return new OpenAPI().components(components).info(info).externalDocs(externalDocs);
	}

}
