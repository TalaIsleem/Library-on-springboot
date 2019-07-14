package io.booksLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.booksLibrary.entities.Novel;


public interface NovelRepository extends JpaRepository <Novel, Long> {

}
