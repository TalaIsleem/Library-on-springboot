package io.boksLibrary.book;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.NotBlank;

import io.boksLibrary.author.Author;

public class BookRequest {
	
	@NotBlank(message="name of book should not be null or blank")
	@Pattern(regexp = "^[A-Za-z]+$", message="The name should has just alphabetic characters")
	private String name;
	
	@NotNull
	@Min(value=1, message = "Number of book copies should not be less than 1")
	private int copies;
	 
	@NotNull(message="author id should not be null")
	private Long authorId;
	
	
	public BookRequest() {	}
	
	public BookRequest(String name, int copies, Long authorId) {
		this.name = name;
		this.copies = copies;
		this.authorId = authorId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	
}
