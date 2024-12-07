package com.klef.jfsd.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository br;
	
	public String updateBook(Book b)
	{
		System.out.println(b.getId());
		System.out.println(b.getAuthor());
		
		Optional<Book> book = br.findById(b.getId());
		
		if(book.isPresent())
		{
			var booke = book.get();
			booke.setAuthor(b.getAuthor());
			booke.setGenre(b.getGenre());
			booke.setPrice(b.getPrice());
			booke.setTitle(b.getTitle());
			booke.setYear(b.getYear());
			
			br.save(booke);
			return "Update SuccessFully";
		}
		return "No Book is associated with such id";
	}
}
