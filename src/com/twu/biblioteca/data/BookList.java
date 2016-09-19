package com.twu.biblioteca.data;

import java.util.Collections;
import java.util.List;

/**
 * Created by ncyang on 9/13/16.
 */
public class BookList {

    private List<Book> bookList;

    public BookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book update(Book oldBook, Book newBook) {
        Collections.replaceAll(bookList, oldBook, newBook);
        return newBook;
    }
}
