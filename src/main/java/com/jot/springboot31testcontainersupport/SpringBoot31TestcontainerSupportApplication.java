package com.jot.springboot31testcontainersupport;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBoot31TestcontainerSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot31TestcontainerSupportApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepo) {
		return args -> {
			bookRepo.deleteAll();
			bookRepo.insert(new Book(1,"Lord Of the Rings", "J.R.R. Tolkien"));
			bookRepo.insert(new Book(2,"Lord of Flies", "J.R.R. Tolkien"));
			bookRepo.insert(new Book(3,"1984", "J.R.R. Tolkien"));
		};
	}
}
