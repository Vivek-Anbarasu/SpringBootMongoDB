package com.springbootmongodb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateBookRequest {

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

