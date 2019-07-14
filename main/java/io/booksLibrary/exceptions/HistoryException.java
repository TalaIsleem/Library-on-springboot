package io.booksLibrary.exceptions;

public class HistoryException extends Exception {

	private String exceptionMsg;
	   
	   public HistoryException(String exceptionMsg) {
		   super(exceptionMsg);
	      this.exceptionMsg = exceptionMsg;
	   }
	   public String getExceptionMsg(){
	      return this.exceptionMsg;
	   }
	   public void setExceptionMsg(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }
	   
}
