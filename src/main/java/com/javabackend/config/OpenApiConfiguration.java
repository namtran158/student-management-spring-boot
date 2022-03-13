package com.javabackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Student Management System")
						.description(null)
						.version(null)
						.license(new License().name("NO LICENSE").url("https://www.facebook.com/namleo15/"))
						.contact(new Contact()
								.email("namtranjr1508@gmail.com")
								.name("Tran Hoai Nam")
								.url("https://www.facebook.com/namleo15/")))
				.externalDocs(new ExternalDocumentation()
						.description("Spring Documentation")
						.url("https://docs.spring.io/spring-framework/docs/current/reference/html/"));
	}
}
