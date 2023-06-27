package com.jot.springboot31testcontainersupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @GetMapping
    @RequestMapping("/books")
    public Iterable<Book> getBooks() {
        return bookRepo.findAll();
    }
}
