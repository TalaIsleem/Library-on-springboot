package io.boksLibrary.history;

import java.util.List;

public interface HistoryService {

	public History getHistory(Long id);
	
	public List<History> getHistories ();
	
	public void addHistory(History history) throws HistoryException;
	
	public void updateHistory(History history);
	
	public void deleteHistory(Long id);
	
	public List<History> getUsersLikeBook(Long bookId);
	
	public List<History> getBooksLikedByUser(Long userId);
}
