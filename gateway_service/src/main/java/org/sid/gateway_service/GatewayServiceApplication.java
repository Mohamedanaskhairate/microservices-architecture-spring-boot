package org.sid.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	//@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(
			ReactiveDiscoveryClient rdc ,
			DiscoveryLocatorProperties properties){
		return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
	}
 @Bean
 RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

	 return builder.routes()

			 .route((r)->r.path("/coproprietes/**").uri("http://localhost:8081/"))
			 .route((r)->r.path("/compteBancaires/**").uri("http://localhost:8081/"))
			 .route((r)->r.path("/coproprietaires/**").uri("http://localhost:8082/"))
			 .route((r)->r.path("/lots/**").uri("http://localhost:8083/"))
			 .route((r)->r.path("/relevers/**").uri("http://localhost:8083/"))
			 .route((r)->r.path("/mandats/**").uri("http://localhost:8084/"))
			 .build();

 }
}
