package library.patterns.factory;

import library.domain.Book;
import library.domain.Patron;

public class EntityFactory {
    public static Book createBook(String title, String author, String isbn, int year) {
        return new Book(title, author, isbn, year);
    }

    public static Patron createPatron(String id, String name, String email) {
        return new Patron(id, name, email);
    }
}
