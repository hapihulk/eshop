package com.eshop.bookservice.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private LocalDate publishDate;

	public Book(@NotNull String name, @NotNull LocalDate publishDate) {
		this.name = name;
		this.publishDate = publishDate;
	}
}
