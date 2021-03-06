package com.sprboot.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Springbootprj1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootprj1Application.class, args);
	}
	
	@Bean
	
	 public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.sprboot.demo.controllers"))
                .build()
                .apiInfo(new ApiInfo("SPRING WITH SWAGGER API","API CREATION","1.0",  "Free to Use", new Contact("Aravi","/api" ,"aravicoder@gmail.com"), "API licence", "/api", Collections.emptyList()));

	}
}
