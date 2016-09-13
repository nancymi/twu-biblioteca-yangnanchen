package com.twu.biblioteca.data;

/**
 * Created by ncyang on 9/13/16.
 */
public class Book {

    private final String name;
    private final String author;
    private final String publishYear;

    public Book(String name, String author, String publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publishYear;
    }
}
