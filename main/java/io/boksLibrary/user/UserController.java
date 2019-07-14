package io.boksLibrary.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.boksLibrary.book.Book;

@RestController
public class UserController {
	
	@Autowired
	UserServiceIMP userService;

	@RequestMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@RequestMapping(method=RequestMethod.POST, value="/users/{userId}/likeBook/{bookId}")
	public void addUserLikeBook(@PathVariable Long userId,@PathVariable Long bookId) {
		userService.addUserLikeBook(userId,bookId);
	}
	@RequestMapping("bookLikers/{bookId}")
	public List<User> getBookLikers(@PathVariable String bookId) {
		return userService.getBookLikers(bookId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
