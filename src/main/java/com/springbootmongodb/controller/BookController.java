package com.springbootmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodb.collection.Book;
import com.springbootmongodb.dto.SaveBookRequest;
import com.springbootmongodb.dto.UpdateBookRequest;
import com.springbootmongodb.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService personService;


    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return personService.getAllBooks();
    }
    
    @PostMapping("/saveBook")
    public ResponseEntity<String> saveBook(@RequestBody SaveBookRequest saveBookRequest) {
    	personService.saveBook(saveBookRequest);
    	return new ResponseEntity<>(String.valueOf(saveBookRequest.getTitle()+" has been successfully created"), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
    	personService.updateBook(updateBookRequest);
    	return new ResponseEntity<>(String.valueOf(updateBookRequest.getTitle()+" has been successfully updated"), HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") String id) {
    	personService.deleteBook(id);
    	return new ResponseEntity<>(id+" has been successfully deleted", HttpStatus.NO_CONTENT);
    }


}
