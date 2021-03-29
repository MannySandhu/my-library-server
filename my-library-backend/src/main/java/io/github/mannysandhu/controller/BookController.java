package io.github.mannysandhu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mannysandhu.dto.volumeDto.Item;
import io.github.mannysandhu.exception.ResourceNotFoundException;
import io.github.mannysandhu.httpClient.BookHttpClient;
import io.github.mannysandhu.model.Book;
import io.github.mannysandhu.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	private BookHttpClient bookHttpClient = new BookHttpClient();

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
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable long id, @RequestBody Book bookDetails) {
		
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found."));
		
		// Updating read status only
//		book.setVolumeStartedStatus(bookDetails.getVolumeStartedStatus());
//		book.setVolumeCompletedStatus(bookDetails.getVolumeCompletedStatus());
//		book.setPagesRead(bookDetails.getPagesRead());
		
		Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}
	
	/*
	 * Google Books REST APIs
	 */
	// Get book resource by ISBN identifier
	@GetMapping("/books/search/isbn/{isbn}")
	public Book getBookByIsbn(@PathVariable String isbn) {
		Book book = null;
		try {
			book = bookHttpClient.getVolumeByIsbn(isbn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	// Get book resource by terms
//	@GetMapping("/books/search/{terms}")
//	public String getBookByTerms(@PathVariable String terms) {
//		String book = "";
//		try {
//			book = bookHttpClient.getVolumeByTerms(terms);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return book;
//	}
}
 