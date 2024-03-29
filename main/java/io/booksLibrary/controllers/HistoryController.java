package io.booksLibrary.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.booksLibrary.entities.Author;
import io.booksLibrary.entities.Book;
import io.booksLibrary.entities.History;
import io.booksLibrary.entities.User;
import io.booksLibrary.exceptions.HistoryException;
import io.booksLibrary.servicesIMP.AuthorServiceIMP;
import io.booksLibrary.servicesIMP.HistoryServiceIMP;

@RestController

public class HistoryController {
	@Autowired
	HistoryServiceIMP historyService;
	
	@RequestMapping("/history")
	public List<History> getHistories(){
		return historyService.getHistories();
	}
	
	@RequestMapping("/history/{id}")
	public History getHistory(@PathVariable Long id){
		return historyService.getHistory(id);
	}
	
	@RequestMapping("/history/book/{id}")
	public List<History> getUsersLikeBook(@PathVariable Long id){
		return historyService.getUsersLikeBook(id);
	}
	
	@RequestMapping("/history/user/{id}")
	public List<History> getBooksLikedByUser(@PathVariable Long id){
		return historyService.getBooksLikedByUser(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/history")
	public void addHistory (@Valid @RequestBody History history) throws HistoryException {
		 historyService.addHistory(history);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/history/{id}")
	public void updateHistory(@PathVariable Long id,@Valid @RequestBody History history){
		historyService.updateHistory(history);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/history/{id}")
	public void updateHistory(@PathVariable Long id){
		historyService.deleteHistory(id);
	}
}
