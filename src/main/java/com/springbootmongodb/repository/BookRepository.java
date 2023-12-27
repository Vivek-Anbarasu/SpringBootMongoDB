package com.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springbootmongodb.collection.Book;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {

}
