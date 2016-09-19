package com.twu.biblioteca.manager;

import com.twu.biblioteca.data.Book;

import java.util.List;

/**
 * Created by ncyang on 9/19/16.
 */
public class BibliotecaManager {

    private static BibliotecaManager instance;

    private BookManager bookManager;

    private BibliotecaManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    public static BibliotecaManager getInstance(BookManager bookManager) {
        if (instance == null) {
            instance = new BibliotecaManager(bookManager);
        }
        return instance;
    }

    public List<String> showBooks() {
        return bookManager.getBookStrList();
    }

    public String showBooksEmpty() {
        return bookManager.getEmptyPrompt();
    }

    public List<String> showBorrowedBooks() {
        return bookManager.getBorrowedBookStrList();
    }

    public List<String> showUnborrowedBooks() {
        return bookManager.getUnborrowedBookStrList();
    }

    public void update(Book book) {
        bookManager.update(book);
    }
}
