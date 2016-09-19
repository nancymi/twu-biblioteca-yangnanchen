package com.twu.biblioteca.manager;

import com.twu.biblioteca.data.Book;
import com.twu.biblioteca.data.Customer;
import com.twu.biblioteca.manager.LibrarianManager.CheckoutListener;
import com.twu.biblioteca.manager.LibrarianManager.ReturnListener;

import java.util.List;

/**
 * Created by ncyang on 9/19/16.
 */
public class CustomerManager {

    private static CustomerManager instance;

    private final BibliotecaManager bibliotecaManager;
    private final LibrarianManager librarianManager;
    private Customer customer;

    private CustomerManager(BibliotecaManager bibliotecaManager, LibrarianManager librarianManager) {
        this.bibliotecaManager = bibliotecaManager;
        this.librarianManager = librarianManager;
    }

    public static CustomerManager getInstance(BibliotecaManager bibliotecaManager, LibrarianManager librarianManager) {
        if (instance == null) {
            instance = new CustomerManager(bibliotecaManager, librarianManager);
        }
        return instance;
    }

    public void register(Customer customer) {
        this.customer = customer;
    }

    public List<String> listBooks() {
        return bibliotecaManager.showBooks();
    }

    public void checkoutBook(Book book, CheckoutListener checkoutListener) {
        librarianManager.doCheckout(book, checkoutListener);
    }

    public void returnBook(Book book, ReturnListener returnListener) {
        librarianManager.doReturn(book, returnListener);
    }

    public void unregister() {
        customer = null;
    }
}
