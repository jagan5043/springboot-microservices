package com.java.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service Rest APIs",
				description = "Organization Service Rest APIs documentation",
				version = "v1.0",
				contact = @Contact(
						name = "jagan",
						email = "jagan5043@gmail.com",
						url = "https://javaguides.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://javaguides.net"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service Rest APIs documentation",
				url = "https://javaguides.net"
		)
)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
