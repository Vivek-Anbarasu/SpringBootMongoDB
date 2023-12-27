package com.springbootmongodb.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@Document(collection = "BookStore")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @Id
    private String id; 
    
    private String title;
    private String author;
    private String country;
    private String imageLink;
    private String language;
    private String link;
    private Integer pages;
    private Integer year;

}
