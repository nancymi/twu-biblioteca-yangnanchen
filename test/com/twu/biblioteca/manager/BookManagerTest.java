package com.twu.biblioteca.manager;

import com.twu.biblioteca.data.Book;
import com.twu.biblioteca.data.BookList;
import org.junit.Before;
import org.junit.Test;
import source.Environment;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ncyang on 9/18/16.
 */
public class BookManagerTest {

    private List<String> expectedBookStrList;
    private List<String> expectedEmptyBookStrList;
    private String expectedEmptyPrompt;

    @Before
    public void setUp() throws Exception {
        expectedBookStrList = new ArrayList<String>();
        expectedEmptyBookStrList = new ArrayList<String>();
        expectedEmptyPrompt = "Sorry, there are no book.";

        expectedBookStrList.add("Book name: book1, author: Author1, published year: 1946, is borrowed: false");
        expectedBookStrList.add("Book name: book2, author: Author2, published year: 1927, is borrowed: false");
        expectedBookStrList.add("Book name: book3, author: Author3, published year: 1949, is borrowed: false");

        expectedEmptyBookStrList.add(expectedEmptyPrompt);
    }

    @Test
    public void when_call_get_books_then_return_book_list_str() throws Exception {
        BookManager bookManager = BookManager.getInstance(Environment.getBooksByEnvironment());
        List<String> booksStrList = bookManager.getBookStrList();
        assertArrayEquals("when_call_get_books_then_return_book_list_str",
                expectedBookStrList.toArray(),
                booksStrList.toArray());
    }

    @Test
    public void when_call_show_books_and_books_empty_then_return_empty_prompt() throws Exception {
        List<Book> books = new ArrayList<Book>();
        BookList bookList = mock(BookList.class);
        when(bookList.getAllBook()).thenReturn(books);

        BookManager bookManager = BookManager.getInstance(bookList);
        List<String> emptyBooksStrList = bookManager.getBookStrList();
        assertArrayEquals("when_call_show_books_and_books_empty_then_return_empty_prompt",
                expectedEmptyBookStrList.toArray(),
                emptyBooksStrList.toArray());
    }

    @Test
    public void when_call_show_books_and_books_null_then_return_empty_prompt() throws Exception {
        BookList bookList = mock(BookList.class);
        when(bookList.getAllBook()).thenReturn(null);

        BookManager bookManager = BookManager.getInstance(bookList);
        List<String> emptyBooksStrList = bookManager.getBookStrList();
        assertArrayEquals("when_call_show_books_and_books_null_then_return_empty_prompt",
                expectedEmptyBookStrList.toArray(),
                emptyBooksStrList.toArray());
    }

    @Test
    public void when_call_get_empty_prompt_then_return_empty_prompt() throws Exception {
        BookManager bookManager = BookManager.getInstance(null);
        String emptyPrompt = bookManager.getEmptyPrompt();
        assertEquals(expectedEmptyPrompt, emptyPrompt);
    }
}