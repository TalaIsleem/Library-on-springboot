package io.booksLibrary.servicesIMP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.booksLibrary.entities.Author;
import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.History;
import io.booksLibrary.entities.User;
import io.booksLibrary.exceptions.HistoryException;
import io.booksLibrary.repositories.AuthorRepository;
import io.booksLibrary.repositories.BookRepository;
import io.booksLibrary.repositories.HistoryRepository;
import io.booksLibrary.services.HistoryService;

@Service
public class HistoryServiceIMP implements HistoryService{

	@Autowired
	HistoryRepository historyRepository;
	
	@Autowired
	BookServiceIMP bookService;
	
	@Override
	public History getHistory(Long id) {
		return historyRepository.findOne(id);
	}
	
	@Override
	public List<History> getHistories () {
		List<History> histories = new ArrayList<>();
		historyRepository.findAll().forEach(histories::add);
		return histories;
	}
	
	@Override
	public void addHistory(History history) throws HistoryException {
		List<History> histories = getHistories();
		for(History h: histories) {
			if(h.getBook().getId().equals(history.getBook().getId()) && h.getUser().getId().equals(history.getUser().getId())) {
				throw new HistoryException("This user has already borrowed this book");
			}
		}
		Book book;
		book = bookService.getBook(history.getBook().getId());
		if(book.getCopies()==0) {
			throw new HistoryException("This book has already out of stuck");
			}
		book.decCopies();
		bookService.updateBook(book);
		historyRepository.save(history);
		}
	
	@Override
	public void updateHistory(History history) {
		historyRepository.save(history);
	}
	
	@Override
	public void deleteHistory(Long id) {
		 historyRepository.delete(id);
	}
	
	@Override
	public List<History> getUsersLikeBook(Long bookId){
		List<History> histories= new ArrayList <>();
		historyRepository.findByBookId(bookId).forEach(histories::add);
		return histories;
	}
	
	@Override
	public List<History> getBooksLikedByUser(Long userId){
		List<History> histories= new ArrayList <>();
		historyRepository.findByUserId(userId).forEach(histories::add);
		return histories;
	}
}
