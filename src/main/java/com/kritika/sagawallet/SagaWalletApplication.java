package com.kritika.sagawallet;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SagaWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SagaWalletApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Saga Wallet System")
				.version("1.0")
				.description("""
					A distributed wallet system built with the **Saga Pattern** and **ShardingSphere**.
					
					## Features
					- ⚡ Horizontal DB sharding across 2 MySQL instances
					- 🔄 Distributed Saga orchestration with compensation
					- 🛡️ Idempotent transfers via requestId
					- 💰 Real-time wallet balance management
					""")
				.contact(new Contact()
					.name("Kritika Mishra")
					.email("your-email@example.com")));
	}
}