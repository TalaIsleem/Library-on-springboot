package io.boksLibrary.book.novels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.boksLibrary.author.Author;
import io.boksLibrary.book.Book;


@RestController
public class NovelController {


	@Autowired
	NovelServiceIMP novelServiceIMP;
	
	@RequestMapping("/novels")
	public List<Novel> getNovels(){
		return novelServiceIMP.getNovels();
	}
	
	@RequestMapping("/novels/{id}")
	public Novel getNovel(@PathVariable Long id){
		return novelServiceIMP.getNovel(id);
	}
	
	@RequestMapping(value="/novels", method = RequestMethod.POST)
	public void addNovel(@RequestBody Novel novel){
		 novelServiceIMP.addNovel(novel);
	//	return novel;
	}
}
