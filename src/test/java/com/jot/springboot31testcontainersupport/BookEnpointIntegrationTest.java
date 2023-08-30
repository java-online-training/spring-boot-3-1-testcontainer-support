package com.jot.springboot31testcontainersupport;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(  webEnvironment = WebEnvironment.RANDOM_PORT ) 
@Testcontainers
class SpringBoot31TestcontainerSupportApplicationTests {

	@LocalServerPort
        private int randomServerPort;

	@ServiceConnection
	@Container
	static MongoDBContainer container = new MongoDBContainer("mongo:latest");

	@Test
	public void testBookEndpoint() {

		RestTemplate template = new RestTemplate();

		Book[] books = template.getForObject("http://localhost:"+randomServerPort+"/books", Book[].class);

		Assert.assertEquals(3, books.length);
	}
}
