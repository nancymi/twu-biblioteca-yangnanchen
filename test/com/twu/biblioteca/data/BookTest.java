package com.twu.biblioteca.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ncyang on 9/13/16.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("name", "author", "1989");
    }

    @Test
    public void when_get_name_then_return_name() throws Exception {
        assertEquals("name", book.getName());
    }

    @Test
    public void when_get_author_then_return_author() throws Exception {
        assertEquals("author", book.getAuthor());
    }

    @Test
    public void when_get_published_year_then_return_1989() throws Exception {
        assertEquals("1989", book.getPublishYear());
    }
}