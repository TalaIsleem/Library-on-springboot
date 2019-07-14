package io.booksLibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.booksLibrary.entities.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

	public List<Book> findByAuthorId(Long authorId);
	
}
