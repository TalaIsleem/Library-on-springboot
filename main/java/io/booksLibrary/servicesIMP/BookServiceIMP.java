package io.booksLibrary.servicesIMP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.History;
import io.booksLibrary.entities.Novel;
import io.booksLibrary.repositories.BookRepository;
import io.booksLibrary.services.BookService;

@Service
public class BookServiceIMP implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	HistoryServiceIMP historyService;
	
	@Override
	public List<Book> getBooks (){ 
		List<Book> books = new ArrayList <>();
		 bookRepository.findAll().forEach(books::add);
		 return books;
	}
	
	@Override
	public List<Book> getAuthorBooks (Long id){ 
		List<Book> books = new ArrayList <>();
		 bookRepository.findByAuthorId(id).forEach(books::add);
		 return books;
	}
	
	@Override
	public Book getBook (Long id){ 
	return 	bookRepository.findOne(id);
	}
	
	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	@Override
	public void addNovel(Novel novel) {
		
	}
	
	@Override
	public void deleteBook(Long id) {
		List <History> histories= historyService.getHistories();
		for(History h : histories) {
			if(h.getBook().getId().equals(id)) {
				historyService.deleteHistory(h.getId());
				break;
			}
		}
		bookRepository.delete(id);
	}
}
