package io.booksLibrary.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.User;

public interface UserService {
	public List<User> getUsers();
	
	public User getUser(Long id);
	
	public List<User> getBookLikers(String bookId);
	
	public void updateUser(User user);
	
	public void addUserLikeBook(Long userId, Long bookId);
	
	public void addUser(User user);
	
	public void deleteUser(Long id);
}
