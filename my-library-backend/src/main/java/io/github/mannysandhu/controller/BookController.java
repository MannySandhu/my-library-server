package io.github.mannysandhu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mannysandhu.exception.ResourceNotFoundException;
import io.github.mannysandhu.model.Book;
import io.github.mannysandhu.repository.BookByIsbnHttpClient;
import io.github.mannysandhu.repository.BookByTermsHttpClient;
import io.github.mannysandhu.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	/*
	 * Database CRUD REST APIs
	 */
	// Get all books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	// Create book resource
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	// Get book resource by id
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
		return ResponseEntity.ok(book);
	}
	
	// Delete a book resource
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBookById(@PathVariable long id){
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
		bookRepository.delete(book);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// Update a book resource
	@PutMapping("/books/{id}/{pagesRead}/{bookStatus}")
	public ResponseEntity<Book> updateBookById(@PathVariable long id, 
			@PathVariable long pagesRead, @PathVariable String bookStatus) {
		
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found."));
		
		// Updating read status only
		book.setPagesRead(pagesRead);
		book.setBookStatus(bookStatus);
		
		Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}
	
	/*
	 * Google Books REST APIs
	 */
	// Get book resource by ISBN identifier
	@GetMapping("/books/isbn/{isbn}")
	public Book getBookByIsbn(@PathVariable long isbn) {
		Book book = null;
		try {
			book = BookByIsbnHttpClient.getVolumeByIsbn(isbn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	// Get many book resources by terms
	@GetMapping("/books/terms/{terms}")
	public List<Book> getBookByTerms(@PathVariable String terms) {
		List<Book> books = new ArrayList<Book>();
		try {
			books = BookByTermsHttpClient.getVolumeByTerms(terms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}
}
 