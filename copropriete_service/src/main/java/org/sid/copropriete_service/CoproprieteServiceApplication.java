package org.sid.copropriete_service;

import org.sid.copropriete_service.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)

public class CoproprieteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoproprieteServiceApplication.class, args);
	}

}
