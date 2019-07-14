package io.bookLibrary.DTOs;

import io.booksLibrary.entities.Book;

public class BookResponse {
	
	private String name;
	
	private int copies;

	private String authorName;

	public BookResponse(Book book) {
		this.name = book.getName();
		this.authorName = book.getAuthor().getName();
		this.copies = book.getCopies();
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getCopies() {
		return copies;
	}
	

	public void setCopies(int copies) {
		this.copies = copies;
	}
}
