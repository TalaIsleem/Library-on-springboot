package io.booksLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.booksLibrary.entities.Author;
import io.booksLibrary.entities.Book;
import io.booksLibrary.servicesIMP.AuthorServiceIMP;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorServiceIMP authorService;
	
	@RequestMapping("/authors")
	public List<Author> getAuthors(){
		return authorService.getAuthors();
	}
	
	@RequestMapping("/authors/{id}")
	public Author getAuthor(@PathVariable Long id){
		return authorService.getAuthor(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/authors")
	public void addBook (@RequestBody Author author) {
		authorService.addAuthor(author);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/authors/{id}")
	public void updateBook(@PathVariable String id, @RequestBody Author author){
		authorService.updateAuthor(author);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/authors/{id}")
	public void updateBook(@PathVariable Long id){
		authorService.deleteAuthor(id);
	}
}
