package com.java.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title="Department Service Rest APIs",
				description = "Department Service Rest APIs documentation",
				version = "v1",
				contact = @Contact(
						name = "jagan",
						email = "jagan5043@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.javaguides.net"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department-Service-Doc",
				url = "https://www.javaguides.net"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
