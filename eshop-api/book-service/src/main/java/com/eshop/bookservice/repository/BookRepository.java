package com.eshop.bookservice.persistence;

import org.springframework.data.repository.CrudRepository;

import com.eshop.bookservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
