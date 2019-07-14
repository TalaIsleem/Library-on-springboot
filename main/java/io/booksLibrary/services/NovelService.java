package io.booksLibrary.services;

import java.util.List;

import io.booksLibrary.entities.Novel;

public interface NovelService {
	
	public void addNovel(Novel novel);
	
	public List<Novel> getNovels();
	
	public Novel getNovel(Long id);
}
