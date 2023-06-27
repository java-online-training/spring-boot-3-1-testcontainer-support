package com.jot.springboot31testcontainersupport;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class SpringBoot31TestcontainerSupportApplicationTests {

	@ServiceConnection
	@Container
	static MongoDBContainer container = new MongoDBContainer("mongo:latest");

	@Autowired
	BookRepository bookRepo;

	@Test
	void testBookRepo() {
		Assert.assertEquals(3, bookRepo.findAll().size());
		
	}

}
