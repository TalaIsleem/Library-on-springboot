package io.booksLibrary.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.bookLibrary.DTOs.BookRequest;
import io.bookLibrary.DTOs.BookResponse;
import io.booksLibrary.entities.Author;
import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.Novel;
import io.booksLibrary.servicesIMP.AuthorServiceIMP;
import io.booksLibrary.servicesIMP.BookServiceIMP;

@RestController
public class BookController {
	
	@Autowired
	BookServiceIMP bookService;
	
	@Autowired
	AuthorServiceIMP authorService;
	
	@RequestMapping("/books")
	public List<BookResponse> getBooks(){
		List<BookResponse> bookRess = new ArrayList<>();
		List<Book> books=bookService.getBooks();
		books.stream().map(book -> bookRess.add(new BookResponse(book))).collect(Collectors.toList());
		return bookRess;
		
	}
	
	
	@RequestMapping("/books/{id}")
	public BookResponse getBook(@PathVariable Long id){
		Book book= bookService.getBook(id);
		BookResponse b=new BookResponse(book);
		return b;
	}
	@RequestMapping("/author/books/{id}")
	public List<Book> getAuthorBooks(@PathVariable Long id){
		return bookService.getAuthorBooks(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/books")
	public void addBook (@Valid @RequestBody BookRequest book) {
		//List<Author> authors=authorService.getAuthors();
		
		Book b = new Book(book);
		//b.setName(book.getName());
		bookService.addBook(b);
	}
	
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/books/{id}")
	public void updateBook(@PathVariable Long id, @RequestBody BookRequest book){
		Book b = new Book(book);
		b.setId(id);
		bookService.updateBook(b);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/books/{id}")
	public void deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
	}

	
}
