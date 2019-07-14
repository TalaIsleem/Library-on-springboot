package io.boksLibrary.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository <Book, Long> {

	public List<Book> findByAuthorId(Long authorId);
	
}
