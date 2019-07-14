package io.boksLibrary.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.boksLibrary.book.Book;

public interface UserRepository extends JpaRepository <User, Long> {
public List<User> findByBooksId(String id);
}
