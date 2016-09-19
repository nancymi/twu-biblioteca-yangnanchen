package com.twu.biblioteca.manager;

import com.twu.biblioteca.data.Book;
import com.twu.biblioteca.data.Customer;
import com.twu.biblioteca.manager.LibrarianManager.CheckoutListener;
import com.twu.biblioteca.manager.LibrarianManager.ReturnListener;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by ncyang on 9/19/16.
 */
public class CustomerManagerTest {

    private CustomerManager customerManager;

    @Test
    public void when_customer_start_application_then_register_will_be_called() throws Exception {
        BibliotecaManager bibliotecaManager = mock(BibliotecaManager.class);
        LibrarianManager librarianManager = mock(LibrarianManager.class);

        customerManager = CustomerManager.getInstance(bibliotecaManager, librarianManager);
        customerManager.register(new Customer());
    }

    @Test
    public void when_customer_choose_list_books_then_list_books_will_be_called() throws Exception {
        BibliotecaManager bibliotecaManager = mock(BibliotecaManager.class);
        LibrarianManager librarianManager = mock(LibrarianManager.class);

        customerManager = CustomerManager.getInstance(bibliotecaManager, librarianManager);
        customerManager.listBooks();
    }

    @Test
    public void when_customer_checkout_book_then_checkout_will_be_called() throws Exception {
        BibliotecaManager bibliotecaManager = mock(BibliotecaManager.class);
        LibrarianManager librarianManager = mock(LibrarianManager.class);
        customerManager = CustomerManager.getInstance(bibliotecaManager, librarianManager);

        Book book = mock(Book.class);
        CheckoutListener checkoutListener = mock(CheckoutListener.class);
        customerManager.checkoutBook(book, checkoutListener);
    }

    @Test
    public void when_customer_return_book_then_return_will_be_called() throws Exception {
        BibliotecaManager bibliotecaManager = mock(BibliotecaManager.class);
        LibrarianManager librarianManager = mock(LibrarianManager.class);
        customerManager = CustomerManager.getInstance(bibliotecaManager, librarianManager);

        Book book = mock(Book.class);
        ReturnListener returnListener = mock(ReturnListener.class);
        customerManager.returnBook(book, returnListener);

    }

    @Test
    public void when_customer_choose_quit_then_unregister_will_be_called() throws Exception {
        BibliotecaManager bibliotecaManager = mock(BibliotecaManager.class);
        LibrarianManager librarianManager = mock(LibrarianManager.class);
        customerManager = CustomerManager.getInstance(bibliotecaManager, librarianManager);
        customerManager.unregister();
    }
}