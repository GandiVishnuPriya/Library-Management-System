package library;

import library.core.*;
import library.domain.*;
import library.patterns.factory.EntityFactory;
import library.patterns.observer.LowStockNotifier;
import library.patterns.strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addObserver(new LowStockNotifier());

        Library library = new Library(inventory);

        // Add books
        Book b1 = EntityFactory.createBook("Java Basics", "James Gosling", "111", 2020);
        Book b2 = EntityFactory.createBook("OOP Concepts", "Grady Booch", "222", 2015);
        Book b3 = EntityFactory.createBook("Effective Java", "Joshua Bloch", "333", 2018);
        inventory.addBook(b1, 2);
        inventory.addBook(b2, 1);
        inventory.addBook(b3, 3);

        // Add patron
        Patron p1 = EntityFactory.createPatron("P1", "Vishnu", "vishnu@gmail.com");
        library.registerPatron(p1);

        // Checkout
        System.out.println("\nCheckout:");
        if (library.checkoutBook("P1", "111")) {
            System.out.println("Vishnu checked out Java Basics");
        }

        // === SEARCH DEMOS ===
        System.out.println("\nSearch Demos:");

        // Search by Title
        SearchStrategy titleSearch = new TitleSearchStrategy();
        List<Book> byTitle = library.searchBooks(titleSearch, "Java");
        System.out.println("By Title 'Java': " + byTitle);

        // Search by Author
        SearchStrategy authorSearch = new AuthorSearchStrategy();
        List<Book> byAuthor = library.searchBooks(authorSearch, "Booch");
        System.out.println("By Author 'Booch': " + byAuthor);

        // Search by ISBN
        SearchStrategy isbnSearch = new IsbnSearchStrategy();
        List<Book> byIsbn = library.searchBooks(isbnSearch, "333");
        System.out.println("By ISBN '333': " + byIsbn);

        // Return
        System.out.println("\nReturn:");
        if (library.returnBook("P1", "111")) {
            System.out.println("Vishnu returned Java Basics");
        }
    }
}
