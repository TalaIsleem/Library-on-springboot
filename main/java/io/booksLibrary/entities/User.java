package io.booksLibrary.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "liked_books",
			   joinColumns =  @JoinColumn(name = "user_id") ,
	           inverseJoinColumns = @JoinColumn(name = "book_id") )
	//@JsonManagedReference
	private Set<Book> books;
	 

	@OneToMany (fetch = FetchType.LAZY,
            mappedBy = "user")
	private List<History> histories;
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void addBook(Book book) {
		this.books.add(book);
	}
	public void setName(String name) {
		this.name = name;
	}
	public User( String name) {
		super();
		this.name = name;
	}
	public User() {	}

	
}
