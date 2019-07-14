package io.boksLibrary.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceIMP implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Author getAuthor(Long id) {
		return authorRepository.findOne(id);
	}
	
	@Override
	public List<Author> getAuthors () {
		List<Author> authors = new ArrayList<>();
		authorRepository.findAll().forEach(authors::add);
		return authors;
	}
	
	@Override
	public void addAuthor(Author author) {
		authorRepository.save(author);
	}
	
	@Override
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}
	
	@Override
	public void deleteAuthor(Long id) {
		 authorRepository.delete(id);
	}
}
