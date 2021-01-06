package com.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Book {
    private String name;
    private String isbn;
    private String publisher;

    private Set<Author> authors = new HashSet<>();
}
