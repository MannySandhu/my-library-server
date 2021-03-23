package io.github.mannysandhu.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_shelve")
public class Shelve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "shelve_name")
	private String shelveName;
	
	@Column(name = "books")
	private ArrayList<Book> books = new ArrayList<>();
	
	public Shelve() {
		
	}
	
	public Shelve(String shelveName, ArrayList<Book> books) {
		this.shelveName = shelveName;
		this.books = books;
	}
	
	public String getShelveName() {
		return shelveName;
	}
	public void setShelveName(String shelveName) {
		this.shelveName = shelveName;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBook(Book book) {
		books.add(book);
	}

}
