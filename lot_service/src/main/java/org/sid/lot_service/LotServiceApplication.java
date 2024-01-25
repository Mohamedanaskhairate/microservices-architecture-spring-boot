package org.sid.lot_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LotServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotServiceApplication.class, args);
	}

}
