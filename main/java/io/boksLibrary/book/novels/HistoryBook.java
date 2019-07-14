package io.boksLibrary.book.novels;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import io.boksLibrary.book.Book;

@Entity
//@DiscriminatorValue("history")
public class HistoryBook extends Book{
	
private String historyType;

public HistoryBook(String name, int copies, String historyType) {
	//super(name, copies);
	this.historyType = historyType;
}

public HistoryBook() {
	
}

public String getHistoryType() {
	return historyType;
}

public void setHistoryType(String historyType) {
	this.historyType = historyType;
}


}
