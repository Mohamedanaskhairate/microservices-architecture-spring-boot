package org.sid.coproprietaire_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoproprietaireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoproprietaireServiceApplication.class, args);
	}

}
