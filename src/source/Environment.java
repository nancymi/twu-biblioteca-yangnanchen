package source;

import com.twu.biblioteca.data.Book;
import com.twu.biblioteca.data.BookList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ncyang on 9/19/16.
 */
public class Environment {

    public static BookList getBooksByEnvironment() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("book1", "Author1", "1946"));
        books.add(new Book("book2", "Author2", "1927"));
        books.add(new Book("book3", "Author3", "1949"));
        return new BookList(books);
    }

}
