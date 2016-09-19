package com.twu.biblioteca.comparator;

import com.twu.biblioteca.data.Book;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.*;

/**
 * Created by ncyang on 9/13/16.
 */
public class BookComparatorTest {

    private Comparator comparator;

    @Before
    public void setUp() throws Exception {
        comparator = new BookComparator();
    }

    @Test
    public void when_compare_book_named_abook_and_bbook_then_return_negative_one() throws Exception {
        Book aBook = new Book("abook", "author", "1986");
        Book bBook = new Book("bBook", "author", "1986");
        int compareResult = comparator.compare(aBook, bBook);
        assertEquals(-1, compareResult);
    }

    @Test
    public void when_compare_book_named_bbook_and_abook_then_return_one() throws Exception {
        Book bBook = new Book("bbook", "author", "1986");
        Book aBook = new Book("aBook", "author", "1986");
        int compareResult = comparator.compare(bBook, aBook);
        assertEquals(1, compareResult);
    }

    @Test
    public void when_compare_two_same_name_books_then_return_zero() throws Exception {
        Book aBook1 = new Book("aBook", "author", "1986");
        Book aBook2 = new Book("aBook", "author", "1986");
        int compareResult = comparator.compare(aBook1, aBook2);
        assertEquals(0, compareResult);

    }
}