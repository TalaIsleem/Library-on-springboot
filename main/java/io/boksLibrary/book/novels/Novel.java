package io.boksLibrary.book.novels;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.boksLibrary.author.Author;
import io.boksLibrary.book.Book;

@Entity
//@DiscriminatorValue("novels")
public class Novel extends Book {
	
private String novelType;
//private Author author;

public Novel(String name, int copies, String novelType) {
	super(name, copies);
	this.novelType = novelType;
//	Author author=new Author();
//	author.setId(authorId);
//	super.setAuthor(author);
}

public Novel() {
}

public String getNovelType() {
	return novelType;
}

public void setNovelType(String novelType) {
	this.novelType = novelType;
}

}
