package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.repositories.AuthorRepository;
import com.springframework.spring5webapp.model.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author nosov = new Author("Nikolay", "Nosov");
        Book hedgehog = new Book("Hedgehog in the fog", "123456", "Zorya");
        nosov.getBooks().add(hedgehog);
        authorRepository.save(nosov);
        bookRepository.save(hedgehog);

        Author horstamn = new Author("Kay", "Horstman");
        Book java = new Book("Java in nutshell", "654321", "Headfirst");
        horstamn.getBooks().add(java);
        bookRepository.save(java);
        authorRepository.save(horstamn);
    }
}
