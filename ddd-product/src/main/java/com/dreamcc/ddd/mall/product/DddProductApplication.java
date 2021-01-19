package com.dreamcc.ddd.mall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DddProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddProductApplication.class, args);
	}

}
