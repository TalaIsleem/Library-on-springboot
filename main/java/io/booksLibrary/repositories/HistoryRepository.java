package io.booksLibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.History;
import io.booksLibrary.entities.User;

public interface HistoryRepository extends JpaRepository <History, Long>  {
	
	public List<History> findByUserId(Long id);
	public List<History> findByBookId(Long id);
	
}
