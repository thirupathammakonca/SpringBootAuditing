package com.thiruacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiruacademy.entity.Book;
import com.thiruacademy.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {
	
	 	@Autowired
	    private BookRepository repository;


	    @PostMapping("/saveBook")
	    public Book saveBook(@RequestBody Book book) {
	        return repository.save(book);
	    }

	    @PutMapping("/update/{id}/{pages}")
	    public String updateBook(@PathVariable int id, @PathVariable int pages) {
	        Book book = repository.findById(id).get();
	        book.setPages(pages);
	        repository.save(book);
	        return "Book updated";
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteBook(@PathVariable int id) {
	        repository.deleteById(id);
	        return "Book deleted";
	    }
	    @GetMapping("/getInfo/{id}")
	    public void getInfo(@PathVariable  int id){
	    	Revision<Integer, Book> revisionObj = repository.findLastChangeRevision(id).get();
	    	System.out.println(revisionObj.getRequiredRevisionNumber());
	    	System.out.println(revisionObj.getEntity());
	    }

}
