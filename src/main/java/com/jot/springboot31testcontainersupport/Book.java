package com.jot.springboot31testcontainersupport;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Book(@Id Integer id, String name, String author) {
}
