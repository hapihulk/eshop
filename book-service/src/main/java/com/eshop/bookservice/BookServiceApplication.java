package com.eshop.bookservice;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eshop.bookservice.domain.Book;
import com.eshop.bookservice.persistence.BookRepository;
import com.eshop.bookservice.service.BookService;

@SpringBootApplication
public class BookServiceApplication {

	@Autowired
	private BookService service;

	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@PostConstruct
	public void checkIfWorks() {

		repository.deleteAll();

		service.create(new Book("Java", LocalDate.of(2006, 10, 01)));
		service.create(new Book("Python", LocalDate.of(1999, 05, 15)));

		List<Book> findAll = service.findAll();

		for (Book book : findAll) {
			System.out.println(book.getId() + ":" + book.name());
		}

	}
}
