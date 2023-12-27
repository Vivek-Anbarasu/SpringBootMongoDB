package com.springbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmongodb.collection.Book;
import com.springbootmongodb.dto.SaveBookRequest;
import com.springbootmongodb.dto.UpdateBookRequest;
import com.springbootmongodb.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

	@Override
	public void saveBook(SaveBookRequest saveBookRequest) {
		Book book = Book.builder().title(saveBookRequest.getTitle())
				.author(saveBookRequest.getAuthor())
				.country(saveBookRequest.getCountry())
				.imageLink(saveBookRequest.getImageLink())
				.language(saveBookRequest.getLanguage())
				.link(saveBookRequest.getLink())
				.pages(saveBookRequest.getPages())
				.year(saveBookRequest.getYear())
				.build();
		
		bookRepository.save(book);
	}

	@Override
	public void updateBook(UpdateBookRequest updateBookRequest) {
		Optional<Book> bookPresent = bookRepository.findById(updateBookRequest.getId());
		Book book = null;
		if(bookPresent.isPresent()) {
			book = bookPresent.get();
			book.setTitle(updateBookRequest.getTitle());
			book.setAuthor(updateBookRequest.getAuthor());
			book.setCountry(updateBookRequest.getCountry());
			book.setImageLink(updateBookRequest.getImageLink());
			book.setLanguage(updateBookRequest.getLanguage());
			book.setLink(updateBookRequest.getLink());
			book.setPages(updateBookRequest.getPages());
			book.setYear(updateBookRequest.getYear());
			bookRepository.save(book);
		}
	}

	@Override
	public void deleteBook(String id) {
		bookRepository.deleteById(id);
	}

}
