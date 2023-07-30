package com.jot.springboot31testcontainersupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestApplicationStarter {

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		return new MongoDBContainer("mongo:latest").withReuse(true);
	}

	public static void main(String[] args) {
		SpringApplication.from(ApplicationStarter::main).with(TestApplicationStarter.class).run(args);
	}

}
