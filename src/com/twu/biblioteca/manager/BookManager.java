package com.twu.biblioteca.manager;

import com.sun.istack.internal.NotNull;
import com.twu.biblioteca.data.Book;
import com.twu.biblioteca.data.BookList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ncyang on 9/18/16.
 */
public class BookManager {

    private static final String BOOK_EMPTY_PROMPT = "Sorry, there are no book.";

    private static BookManager instance;

    private final BookList bookList;

    private BookManager(@NotNull BookList bookList) {
        this.bookList = bookList;
    }

    public static BookManager getInstance(@NotNull BookList bookList) {
        if (instance == null) {
            instance = new BookManager(bookList);
        }
        return instance;
    }

    public List<String> getBookStrList() {
        List<String> bookStrList = new ArrayList<String>();

        if (bookList.getAllBooks() == null || bookList.getAllBooks().size() == 0) {
            return bookStrList;
        }

        for (Book book : bookList.getAllBooks()) {
            bookStrList.add(generateBookDescription(book));
        }
        return bookStrList;
    }

    public List<String> getBorrowedBookStrList() {
        List<String> bookStrList = new ArrayList<String>();

        if (bookList.getAllBooks() == null || bookList.getAllBooks().size() == 0) {
            return bookStrList;
        }

        for (Book book : bookList.getAllBooks()) {
            if (book.isBorrowed()) {
                bookStrList.add(generateBookDescription(book));
            }
        }
        return bookStrList;
    }

    public List<String> getUnborrowedBookStrList() {
        List<String> bookStrList = new ArrayList<String>();

        if (bookList.getAllBooks() == null || bookList.getAllBooks().size() == 0) {
            return bookStrList;
        }

        for (Book book : bookList.getAllBooks()) {
            if (!book.isBorrowed()) {
                bookStrList.add(generateBookDescription(book));
            }
        }
        return bookStrList;
    }

    public String getEmptyPrompt() {
        return BOOK_EMPTY_PROMPT;
    }

    private String generateBookDescription(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append("Book name: " + book.getName());
        sb.append(", author: " + book.getAuthor());
        sb.append(", published year: " + book.getPublishYear());
        sb.append(", is borrowed: " + book.isBorrowed());
        return sb.toString();
    }

    public void update(Book book) {
        Book oldBook = getBookByName(book.getName());
        bookList.update(oldBook, book);
    }

    public Book getBookByPosition(int position) {
        return bookList.getAllBooks().get(position);
    }

    public Book getBookByName(String name) {
        for (Book book: bookList.getAllBooks()) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        return null;
    }
}
