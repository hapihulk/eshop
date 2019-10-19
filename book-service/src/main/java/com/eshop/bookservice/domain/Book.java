package com.eshop.bookservice.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private LocalDate publishDate;

	public Book() {
	    }

	public Book(@NotNull String name, @NotNull LocalDate publishDate) {
	        this.name = name;
	        this.publishDate = publishDate;
	    }

	// Generate getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
}
