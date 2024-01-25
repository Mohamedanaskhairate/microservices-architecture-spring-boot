package org.sig.mandat_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MandatServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MandatServiceApplication.class, args);
	}

}
