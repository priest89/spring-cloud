package com.priest.spring28minutes.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Thangvm", "http://www.pirink.com", "pirest89");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation Title", "description", "version",
			"urn:tos", "contact", "", "");
	public static final Set<String> DEFAULT_PRODUCER_AND_CONSUMERS = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCER_AND_CONSUMERS)
				.consumes(DEFAULT_PRODUCER_AND_CONSUMERS);
	}
}
