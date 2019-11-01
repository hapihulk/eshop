package com.eshop.bookservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.bookservice.domain.Book;
import com.eshop.bookservice.persistence.BookRepository;

@Service
public class BookService {

	private BookRepository bookPersistence;

    public BookService(BookRepository bookPersistence) {
        this.bookPersistence = bookPersistence;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Book create(Book book) {
        return bookPersistence.save(book);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Book findById(Long id) {
        return bookPersistence.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Book not found with id:" + id));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Book> findAll() {
        List<Book> people = new ArrayList<>();
        Iterator<Book> iterator = bookPersistence.findAll().iterator();
        iterator.forEachRemaining(people::add);
        return people;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Book book) {
        bookPersistence.delete(book);
    }

}
