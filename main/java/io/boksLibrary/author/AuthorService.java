package io.boksLibrary.author;

import java.util.ArrayList;
import java.util.List;

public interface AuthorService {
	
	public Author getAuthor(Long id);
	
	public List<Author> getAuthors ();
	
	public void addAuthor(Author author);
	
	public void updateAuthor(Author author);
	
	public void deleteAuthor(Long id);
	
}

