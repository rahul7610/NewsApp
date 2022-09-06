package com.stackroute.favouriteservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import com.stackroute.favouriteservice.model.News;
import com.stackroute.favouriteservice.repository.NewsRepository;
import com.stackroute.favouriteservice.service.NewsService;

@RestController
@RequestMapping("/api/")
public class NewsController {
	
//	private final NewsRepository newsRepository;
	
	@Autowired
	NewsService newsService;
	
	
	@PostMapping("news")
	public ResponseEntity<News> saveNews(@RequestBody News news ) throws NewsAlreadyExistsException
	{
		
		this.newsService.saveNews(news);
		 return new ResponseEntity<News>(news,HttpStatus.CREATED);
	}
	
	
	@GetMapping("news")
	public ResponseEntity<List<News>> getallNews() throws NewsAlreadyExistsException, NewsNotFoundException {
	List<News> newslist=this.newsService.getNews(null);
		return new ResponseEntity<List<News>>(newslist,HttpStatus.OK);
		
	}
	
	
//	public ResponseEntity<List<News>> getAllNews()    getNews
//	{
//		List<News> list = this.newsService.getAllNews();
//		
//		return new ResponseEntity<List<News>>(list, HttpStatus.OK);
//	}
//	
	
	
	
	@DeleteMapping("news/{newsId}")
	public ResponseEntity<?> deleteNews(@PathVariable("newsId") Integer bid) throws NewsNotFoundException
	{
		this.newsService.deleteNewsById(bid);
		return new ResponseEntity<String>("Deleted succssfully",HttpStatus.OK);
		}
	
	
//	@GetMapping("news")    getNews
//	@ResponseStatus(HttpStatus.OK)
//	public List<News>getNews()
//	{
//		return newsRepository.getNews();
//	}
//	

	
	
	
	
	
	
}
