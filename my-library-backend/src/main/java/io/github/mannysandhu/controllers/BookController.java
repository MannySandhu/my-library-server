package io.github.mannysandhu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mannysandhu.models.Book;
import io.github.mannysandhu.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
 