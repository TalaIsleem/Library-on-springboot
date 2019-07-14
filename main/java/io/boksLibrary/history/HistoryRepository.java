package io.boksLibrary.history;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.boksLibrary.book.Book;
import io.boksLibrary.user.User;

public interface HistoryRepository extends JpaRepository <History, Long>  {
	
	public List<History> findByUserId(Long id);
	public List<History> findByBookId(Long id);
	
}
