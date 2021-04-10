package io.github.mannysandhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mannysandhu.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	public static final BookByIsbnHttpClient BookByIsbnHttpClient = new BookByIsbnHttpClient();
	public static final BookByTermsHttpClient BookByTermsHttpClient = new BookByTermsHttpClient();
}
