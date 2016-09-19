package com.twu.biblioteca.manager;

import com.twu.biblioteca.data.Book;

/**
 * Created by ncyang on 9/19/16.
 */
public class LibrarianManager {

    private static LibrarianManager instance;

    private BibliotecaManager bibliotecaManager;

    private LibrarianManager(BibliotecaManager bibliotecaManager) {
        this.bibliotecaManager = bibliotecaManager;
    }

    public static LibrarianManager getInstance(BibliotecaManager bibliotecaManager) {
        if (instance == null) {
            instance = new LibrarianManager(bibliotecaManager);
        }
        return instance;
    }

    public void doCheckout(Book book, CheckoutListener checkoutListener) {
        if (book.isBorrowed()) {
            checkoutListener.onFailure("Book has been borrowed.");
        } else {
            book.setBorrowed(true);
            bibliotecaManager.update(book);
            checkoutListener.onSuccess();
        }
    }

    public void doReturn(Book book, ReturnListener returnListener) {
        if (!book.isBorrowed()) {
            returnListener.onFailure("Book doesn't belongs to Bibliote.");
        } else {
            book.setBorrowed(false);
            bibliotecaManager.update(book);
            returnListener.onSuccess();
        }
    }

    public interface CheckoutListener {
        void onSuccess();
        void onFailure(String msg);
    }

    public interface ReturnListener {
        void onSuccess();
        void onFailure(String msg);
    }
}
