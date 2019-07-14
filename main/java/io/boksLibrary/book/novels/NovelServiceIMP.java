package io.boksLibrary.book.novels;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.boksLibrary.book.Book;


@Service
public class NovelServiceIMP implements NovelService{
	
	@Autowired
	NovelRepository novelRepository;

	@Override
	public void addNovel(Novel novel) {
		novelRepository.save(novel);
	}
	
	@Override
	public List<Novel> getNovels (){ 
		List<Novel> novels = new ArrayList <>();
		novelRepository.findAll().forEach(novels::add);
		 return novels;
	}
	
	@Override
	public Novel getNovel (Long id){ 
	return 	novelRepository.findOne(id);
	}
}
