package io.booksLibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.User;

public interface UserRepository extends JpaRepository <User, Long> {
public List<User> findByBooksId(String id);
}
