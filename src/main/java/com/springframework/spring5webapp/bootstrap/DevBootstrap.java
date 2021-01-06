package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import com.springframework.spring5webapp.model.repositories.AuthorRepository;
import com.springframework.spring5webapp.model.repositories.BookRepository;
import com.springframework.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author nosov = new Author("Nikolay", "Nosov");
        Publisher zorya = new Publisher("Zorya", "Kyiv");
        Book hedgehog = new Book("Hedgehog in the fog", "123456", zorya);
        nosov.getBooks().add(hedgehog);
        publisherRepository.save(zorya);
        authorRepository.save(nosov);
        bookRepository.save(hedgehog);

        Author horstamn = new Author("Kay", "Horstman");
        Publisher headfirst = new Publisher("Headfirst", "Kharkiv");
        Book java = new Book("Java in nutshell", "654321", headfirst);
        horstamn.getBooks().add(java);
        publisherRepository.save(headfirst);
        bookRepository.save(java);
        authorRepository.save(horstamn);
    }
}
