package com.jv.crud_operation.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

	@Bean
	public GroupedOpenApi backEndGroup() {
		return GroupedOpenApi.builder().group("backend-api").addOpenApiCustomizer(openApi-> openApi.info(getBanendApiInfo())).packagesToScan("com.jv.crud_operation.controller").build();
	}
	
	@Bean
	public GroupedOpenApi fornEndGroup() {
		return GroupedOpenApi.builder().group("frontEnd-api").addOpenApiCustomizer(openApi-> openApi.info(getBanendApiInfo())).packagesToScan("com.jv.crud_operation.ljskdf").build();
	}
	
	private Info getBanendApiInfo() {
		Contact contact=new Contact();
		contact.setName("Vanny");
		contact.setEmail("Vanny@gmail.com");
		contact.setUrl("https://github.com/Vanny2402/spring_corel");
		return new Info().title("Admin").version("1.0.1").description("Hi Admin").contact(contact);
	}
}
