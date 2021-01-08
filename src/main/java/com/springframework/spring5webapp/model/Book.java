package com.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String isbn;

    @OneToOne
    private Publisher publisher;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_author", joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private final Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String name, String isbn, Publisher publisher) {
        this.name = name;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
