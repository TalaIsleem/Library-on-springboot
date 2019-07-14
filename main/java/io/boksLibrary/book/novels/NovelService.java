package io.boksLibrary.book.novels;

import java.util.List;

public interface NovelService {
	
	public void addNovel(Novel novel);
	
	public List<Novel> getNovels();
	
	public Novel getNovel(Long id);
}
