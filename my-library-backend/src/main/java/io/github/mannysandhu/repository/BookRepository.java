package io.github.mannysandhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mannysandhu.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	// configure data source
	
}
