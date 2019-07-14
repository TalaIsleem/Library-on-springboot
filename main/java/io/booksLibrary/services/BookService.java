package io.booksLibrary.services;

import java.util.List;

import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.Novel;

public interface BookService {

	public List<Book> getBooks ();
	
	public List<Book> getAuthorBooks (Long id);
	
	public Book getBook (Long id);
	
	public void updateBook(Book book);
	
	public void addBook(Book book);
	
	public void deleteBook(Long id);

	void addNovel(Novel novel);
	
	
}
