package com.springbootmongodb.service;

import java.util.List;

import com.springbootmongodb.collection.Book;
import com.springbootmongodb.dto.SaveBookRequest;
import com.springbootmongodb.dto.UpdateBookRequest;

public interface BookService {
	List<Book> getAllBooks();
	void saveBook(SaveBookRequest saveBookRequest);
	void updateBook(UpdateBookRequest updateBookRequest);
	void deleteBook(String id);
}
