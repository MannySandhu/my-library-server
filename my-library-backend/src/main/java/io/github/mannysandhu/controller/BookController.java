package io.github.mannysandhu.controller;

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

import io.github.mannysandhu.exception.ResourceNotFoundException;
import io.github.mannysandhu.model.Book;
import io.github.mannysandhu.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	// get all books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	// create book 
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	// get book by id
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
		return ResponseEntity.ok(book);
	}
	
	// delete a book
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBookById(@PathVariable long id){
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
		bookRepository.delete(book);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// Update a book
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable long id, @RequestBody Book bookDetails) {
		
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found."));
		
		book.setVolumeStatus(bookDetails.getVolumeStatus());
		book.setPagesRead(bookDetails.getPagesRead());
		
		Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}

}
 