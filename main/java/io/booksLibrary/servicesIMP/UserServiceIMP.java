package io.booksLibrary.servicesIMP;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.History;
import io.booksLibrary.entities.User;
import io.booksLibrary.repositories.UserRepository;
import io.booksLibrary.services.UserService;

@Service
public class UserServiceIMP implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	HistoryServiceIMP historyService;
	@Autowired
	BookServiceIMP bookService;

	@Override
	public List<User> getUsers() {
		List<User> users= new ArrayList <>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	@Override
	public User getUser(Long id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public List<User> getBookLikers(String bookId) {
		List<User> users= new ArrayList <>();
		users= userRepository.findByBooksId(bookId);
		return users;
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void addUserLikeBook(Long userId, Long bookId) {
		Book book=bookService.getBook(bookId);
		User user =  getUser(userId);
		Set<Book> books= user.getBooks();
		books.add(book);
		user.setBooks(books);
		userRepository.save(user);
	}
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		List <History> histories= historyService.getHistories();
		for(History h : histories) {
			if(h.getUser().getId().equals(id)) {
				historyService.deleteHistory(h.getId());
				break;
			}
		}
		 userRepository.delete(id);
	}
	
}
