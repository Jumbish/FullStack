package com.springboot.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info =@Info(
			title="Spring boot blog App Rest APIs",
			description="Spring boot blog App Rest APIs Documentation",
			version="v1.0",
			contact= @Contact(
					name="Ramesh",
					email ="ramesh@gmail.com",
					url="www.google.com"
					),
					license= @License(
							name="Apache 2.0",
							url = "https://github.com/Jumbish/FullStack"
							)
			
			),
			externalDocs = @ExternalDocumentation(
					description="Spring boot blog App Rest APIs Documentation",
					url="https://github.com/Jumbish/FullStack"
					)
	
)

public class SpringbootBlogRestApiApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

}
