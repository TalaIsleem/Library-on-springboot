package io.booksLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.booksLibrary.entities.Author;

public interface AuthorRepository extends JpaRepository <Author, Long>  {

}
