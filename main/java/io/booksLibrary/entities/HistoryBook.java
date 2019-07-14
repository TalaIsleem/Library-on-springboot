package io.booksLibrary.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
