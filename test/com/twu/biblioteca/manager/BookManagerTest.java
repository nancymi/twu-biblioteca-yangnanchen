package com.twu.biblioteca.manager;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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

        expectedBookStrList.add("Book name: book1, author: Author1, published year: 1946");
        expectedBookStrList.add("Book name: book2, author: Author2, published year: 1927");
        expectedBookStrList.add("Book name: book3, author: Author3, published year: 1949");

        expectedEmptyBookStrList.add(expectedEmptyPrompt);
    }

    @Test
    public void when_call_get_books_then_return_book_list_str() throws Exception {
        BookManager bookManager = BookManager.getInstance();
        List<String> booksStrList = bookManager.getBooksStrList();
        assertArrayEquals("when_call_get_books_then_return_book_list_str",
                expectedBookStrList.toArray(),
                booksStrList.toArray());
    }

    @Test
    public void when_call_show_books_and_books_empty_then_return_empty_prompt() throws Exception {
        BookManager bookManager = BookManager.getInstance();
        List<String> emptyBooksStrList = bookManager.getBooksStrList();
        assertArrayEquals("when_call_show_books_and_books_empty_then_return_empty_prompt",
                expectedEmptyBookStrList.toArray(),
                emptyBooksStrList.toArray());
    }

    @Test
    public void when_call_get_empty_prompt_then_return_empty_prompt() throws Exception {
        BookManager bookManager = BookManager.getInstance();
        String emptyPrompt = bookManager.getEmptyPeompt();
        assertEquals(expectedEmptyPrompt, emptyPrompt);
    }
}