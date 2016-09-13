package com.twu.biblioteca.comparator;

import com.twu.biblioteca.data.Book;

import java.util.Comparator;

/**
 * Created by ncyang on 9/13/16.
 */
public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book bookA, Book bookB) {
        return compareName(bookA.getName(), bookB.getName());
    }

    private int compareName(String nameA, String nameB) {
        return nameA.compareTo(nameB);
    }
}
